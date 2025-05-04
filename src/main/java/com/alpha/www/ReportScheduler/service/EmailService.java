package com.alpha.www.ReportScheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("nishitmasih20@gmail.com"); // Optional
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
            logger.info("📨 Email sent to: {}", to);
        } catch (Exception e) {
            logger.error("❌ Failed to send email to: {}", to, e);
        }
    }
}

