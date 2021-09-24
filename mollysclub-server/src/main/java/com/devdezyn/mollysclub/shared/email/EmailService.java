package com.devdezyn.mollysclub.shared.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailService implements EmailSender {
  private String fromEmailAddress;
  private final JavaMailSender mailSender;


  public EmailService(@Value("${app.email.from}") String fromEmailAddress, JavaMailSender mailSender) {
    this.fromEmailAddress = fromEmailAddress;
    this.mailSender = mailSender;
  }


  @Override
  @Async
  public void send(String to, String subject, String text) {
    try {
      MimeMessage mimeMessage = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
      helper.setText(text, true);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setFrom(fromEmailAddress);

      mailSender.send(mimeMessage);

    } catch (MessagingException e) {
      log.error(e.getMessage(), e);
      throw new IllegalStateException("failed to send email");
    }
  }

  @Override
  public void sendMailMessageWithAttachments(String to, String subject, String text, String pathToAttachment) {
      // ...
    try {
      MimeMessage message = mailSender.createMimeMessage();
      
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      
      helper.setFrom("noreply@baeldung.com");
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(text);
          
      FileSystemResource file 
        = new FileSystemResource(new File(pathToAttachment));
      helper.addAttachment("Invoice", file);

      mailSender.send(message);

    } catch (SendFailedException sfe) {

    } catch (MessagingException me) {

    }
      // ...
  }
  
  // public void sendMailMessageWithAttachments(String to, String subject, String text) {

  //       mailSender.send(new MimeMessagePreparator() {

  //           @Override
  //           public void prepare(MimeMessage mimeMessage) 
  //                  throws Exception {
  //                 MimeMessageHelper helper =
  //                   new MimeMessageHelper(mimeMessage, true, "UTF-8");
  //                 helper.addTo(to);
  //                 helper.setFrom(fromEmailAddress);
                  
  //                 InputStreamSource data = 
  //                          new ByteArrayResource("".getBytes());

  //                 helper.addAttachment("test.txt", data );
  //                 helper.setSubject(subject);
  //                 helper.setText(text, false);
  //               }
  //           });
  //    }
  
}
