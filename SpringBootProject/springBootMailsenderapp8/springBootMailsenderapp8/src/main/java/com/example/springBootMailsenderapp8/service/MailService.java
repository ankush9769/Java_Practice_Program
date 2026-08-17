package com.example.springBootMailsenderapp8.service;

public interface MailService {
    void sendEmail(
            String to,
            String subject,
            String body
    );
}
