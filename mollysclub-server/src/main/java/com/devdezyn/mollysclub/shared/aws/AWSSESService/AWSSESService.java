package com.devdezyn.mollysclub.shared.aws.AWSSESService;

public interface AWSSESService {
  void send(String to, String subject, String body) throws Exception;
}
