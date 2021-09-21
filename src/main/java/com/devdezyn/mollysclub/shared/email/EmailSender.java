package com.devdezyn.mollysclub.shared.email;

public interface EmailSender {
  void send(String to, String subject, String text);
}
