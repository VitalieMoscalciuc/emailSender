package com.example.sendemail.controller;

import com.example.sendemail.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @GetMapping("/send")
    public void sendEmails(){
        emailSenderService.emailUsers();
    }
}
