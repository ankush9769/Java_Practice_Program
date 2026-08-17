package com.example.springBootMailsenderapp8.controller;


import com.example.springBootMailsenderapp8.DTO.EmailRequest;
import com.example.springBootMailsenderapp8.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequest emailRequest){
        mailService.sendEmail(
                emailRequest.getTo(),
                emailRequest.getSubject(),
                emailRequest.getBody()
        );
        return ResponseEntity.ok("mail send successfully");

    }
}
