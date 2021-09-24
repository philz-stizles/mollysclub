package com.devdezyn.mollysclub.auth.services;

import com.devdezyn.mollysclub.auth.dtos.RegisterRequest;
import com.devdezyn.mollysclub.auth.dtos.RegisterResponse;

public interface RegistrationService {

  public RegisterResponse processConfirmationToken(RegisterRequest request);
  
  public RegisterResponse createUser(RegisterRequest request);

  public RegisterResponse createUserWithEmailConfirmation(RegisterRequest request);

  public RegisterResponse createDoctor(RegisterRequest request);

  public RegisterResponse processDoctorsEmailConfirmation(RegisterRequest request);

  public RegisterResponse createDoctor(String token);

  public RegisterResponse createPatient(RegisterRequest request);

  public RegisterResponse createPatientWithEmailConfirmation(RegisterRequest request);

  public RegisterResponse createGymn(RegisterRequest request);

  public RegisterResponse createGymnWithEmailConfirmation(RegisterRequest request);

  public RegisterResponse createPharmacy(RegisterRequest request);

  public RegisterResponse createPharmacyWithEmailConfirmation(RegisterRequest request);

  public RegisterResponse createLaboratory(RegisterRequest request);

  public RegisterResponse createLaboratoryWithEmailConfirmation(RegisterRequest request);

  public String confirmToken(String token);
}
