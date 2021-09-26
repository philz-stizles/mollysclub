package com.devdezyn.mollysclub.auth.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterResponse;
import com.devdezyn.mollysclub.auth.models.ConfirmationToken;
import com.devdezyn.mollysclub.auth.validators.EmailValidator;
import com.devdezyn.mollysclub.doctor.Doctor;
import com.devdezyn.mollysclub.doctor.DoctorDto;
import com.devdezyn.mollysclub.doctor.DoctorService;
import com.devdezyn.mollysclub.gymn.GymnService;
import com.devdezyn.mollysclub.patient.PatientService;
import com.devdezyn.mollysclub.pharmacy.PharmacyService;
import com.devdezyn.mollysclub.shared.email.EmailSender;
import com.devdezyn.mollysclub.user.User;
import com.devdezyn.mollysclub.user.UserDto;
import com.devdezyn.mollysclub.user.UserMapper;
import com.devdezyn.mollysclub.user.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
  private final EmailValidator emailValidator;
  private final UserService userService;
  private final UserMapper userMapper;
  private final DoctorService doctorService;
  // private final PatientService patientService;
  // private final PharmacyService pharmacyService;
  // private final GymnService gymnService;
  private final ConfirmationTokenService confirmationTokenService;
  private final EmailSender emailSender;

  public RegisterResponse processConfirmationToken(RegisterRequest request) {

    boolean isValidEmail = emailValidator.test(request.getEmail());
    if (!isValidEmail) {
      throw new IllegalStateException("Invalid email address");
    }

    //Create User and retrieve email email confirmation token
    var user = userService.saveUser(request, Arrays.asList("DOCTOR"));

    // 
    String token = confirmationTokenService.saveConfirmationToken(user);

    // Send email notification
    String link = "http://localhost:8080/api/v1/auth/confirmEmail?token=" + token;
    emailSender.send(request.getEmail(), buildEmail(request.getFirstName(), link), null);

    return new RegisterResponse(user.getUsername(), user.getEmail());
  }
  
  public RegisterResponse createUser(RegisterRequest request) {
    var user = userService.createUser(request);

    return new RegisterResponse(user.getUsername(), user.getEmail()) ;
  }

  @Override
  public RegisterResponse createUserWithEmailConfirmation(RegisterRequest request) {
    var user = userService.createUser(request);

    return new RegisterResponse(user.getUsername(), user.getEmail()) ;
  }

  @Override
  public RegisterResponse createDoctor(RegisterRequest request) {
    
    // Save user credentials
    User createdUser = userService.saveUser(request, Arrays.asList("DOCTOR"));

    doctorService.create(createdUser);

    return new RegisterResponse(createdUser.getUsername(), createdUser.getEmail()) ;
  }

  @Override
  public RegisterResponse processDoctorsEmailConfirmation(RegisterRequest request) {
    log.info(request.toString());
    // Save user credentials
    User user = userService.saveUser(request, Arrays.asList("DOCTOR"));

    String token = confirmationTokenService.saveConfirmationToken(user);

    // Send email notification
    String link = "http://localhost:8009/api/v1/auth/confirm-email-create-doctor?token=" + token;
    emailSender.send(request.getEmail(), "Email verification", buildEmail(request.getFirstName(), link));

    return new RegisterResponse();
  }

   @Transactional // All or nothing multiple db writes
  public RegisterResponse createDoctor(String token) {

    ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
        .orElseThrow(() -> new IllegalStateException("token not found"));
    if (confirmationToken.getConfirmedAt() != null) {
      throw new IllegalStateException("Email already confirmed");
    }

    LocalDateTime expiresAt = confirmationToken.getExpiresAt();
    if (expiresAt.isBefore(LocalDateTime.now())) {
      throw new IllegalStateException("Token has expired");
    }

    confirmationTokenService.setConfirmedAt(confirmationToken.getToken());

    log.info(confirmationToken.toString());

    User user = confirmationToken.getUser();

    log.info(String.valueOf(confirmationToken.getUser().getId()));

    UserDto userDto = userService.enableUser(confirmationToken.getUser().getId());

    doctorService.create(user);

    return new RegisterResponse();
  }

  @Override
  public RegisterResponse createPatient(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createPatientWithEmailConfirmation(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createGymn(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createGymnWithEmailConfirmation(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createPharmacy(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createPharmacyWithEmailConfirmation(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createLaboratory(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RegisterResponse createLaboratoryWithEmailConfirmation(RegisterRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Transactional // All or nothing multiple db writes
  public String confirmToken(String token) {

    ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
        .orElseThrow(() -> new IllegalStateException("token not found"));
    if (confirmationToken.getConfirmedAt() != null) {
      throw new IllegalStateException("Email already confirmed");
    }

    LocalDateTime expiresAt = confirmationToken.getExpiresAt();
    if (expiresAt.isBefore(LocalDateTime.now())) {
      throw new IllegalStateException("Token has expired");
    }

    confirmationTokenService.setConfirmedAt(confirmationToken.getToken());

    userService.enableUser(confirmationToken.getUser().getId());

    return "confirmed";
  }

  private String buildEmail(String name, String link) {
        return"<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n"+
                "\n"+
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n"+
                "\n"+
                "<table role=\"presentation\"width=\"100%\"style=\"border-collapse:collapse;min-width:100%;width:100%!important\"cellpadding=\"0\"cellspacing=\"0\"border=\"0\">\n"+
                "<tbody><tr>\n"+
                "<td width=\"100%\"height=\"53\"bgcolor=\"#0b0c0c\">\n"+
                "\n"+
                "<table role=\"presentation\"width=\"100%\"style=\"border-collapse:collapse;max-width:580px\"cellpadding=\"0\"cellspacing=\"0\"border=\"0\"align=\"center\">\n"+
                "<tbody><tr>\n"+
                "<td width=\"70\"bgcolor=\"#0b0c0c\"valign=\"middle\">\n"+
                "<table role=\"presentation\"cellpadding=\"0\"cellspacing=\"0\"border=\"0\"style=\"border-collapse:collapse\">\n"+
                "<tbody><tr>\n"+
                "<td style=\"padding-left:10px\">\n"+
                "\n"+
                "</td>\n"+
                "<td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n"+
                "<span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n"+
                "</td>\n"+
                "</tr>\n"+
                "</tbody></table>\n"+
                "</a>\n"+
                "</td>\n"+
                "</tr>\n"+
                "</tbody></table>\n"+
                "\n"+
                "</td>\n"+
                "</tr>\n"+
                "</tbody></table>\n"+
                "<table role=\"presentation\"class=\"m_-6186904992287805515content\"align=\"center\"cellpadding=\"0\"cellspacing=\"0\"border=\"0\"style=\"border-collapse:collapse;max-width:580px;width:100%!important\"width=\"100%\">\n"+
                "<tbody><tr>\n"+
                "<td width=\"10\"height=\"10\"valign=\"middle\"></td>\n"+
                "<td>\n"+
                "\n"+
                "<table role=\"presentation\"width=\"100%\"cellpadding=\"0\"cellspacing=\"0\"border=\"0\"style=\"border-collapse:collapse\">\n"+
                "<tbody><tr>\n"+
                "<td bgcolor=\"#1D70B8\"width=\"100%\"height=\"10\"></td>\n"+
                "</tr>\n"+
                "</tbody></table>\n"+
                "\n"+
                "</td>\n"+
                "<td width=\"10\"valign=\"middle\"height=\"10\"></td>\n"+
                "</tr>\n"+
                "</tbody></table>\n"+
                "\n"+
                "\n"+
                "\n"+
                "<table role=\"presentation\"class=\"m_-6186904992287805515content\"align=\"center\"cellpadding=\"0\"cellspacing=\"0\"border=\"0\"style=\"border-collapse:collapse;max-width:580px;width:100%!important\"width=\"100%\">\n"+
                "<tbody><tr>\n"+
                "<td height=\"30\"><br></td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td width=\"10\"valign=\"middle\"><br></td>\n"+
                "<td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n"+
                "\n"+
                "<p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi "+name +",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\""+link +"\">Activate Now</a> </p></blockquote>\nLink will expire in 15 minutes. <p>See you soon</p>"+
                "\n"+
                "</td>\n"+
                "<td width=\"10\"valign=\"middle\"><br></td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td height=\"30\"><br></td>\n"+
                "</tr>\n"+
                "</tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n"+
                "\n"+
                "</div></div>";
    }
}
