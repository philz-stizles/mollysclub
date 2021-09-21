package com.devdezyn.mollysclub.shared.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
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
  
}
