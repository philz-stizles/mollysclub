package com.devdezyn.mollysclub.email;

public interface EmailSender {
  void send(String to, String text);
}
