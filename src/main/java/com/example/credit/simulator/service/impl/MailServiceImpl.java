package com.example.credit.simulator.service.impl;

import com.example.credit.simulator.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

  @Autowired
  JavaMailSender mailSender;

  @Value("$.spring.mail.username")
  private String from;

  @Override
  public void senderMail(String to, String subject, String body) {
    try {
      SimpleMailMessage email = new SimpleMailMessage();
      email.setTo(to);
      email.setSubject(subject);
      email.setText(body);
      email.setFrom(from);

      log.info("Sending email to {}",to);

      mailSender.send(email);
    } catch (Exception e) {
      log.error("Falha ao enviar e-mail, {}", e.getMessage());
    }
  }
}
