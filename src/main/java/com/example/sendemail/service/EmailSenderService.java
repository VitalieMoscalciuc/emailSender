package com.example.sendemail.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender emailSender;
    private final WinningService winningService;

    public void emailUsers() {
        winningService.getAllUsers().forEach(user -> {
            String email = user.getEmail();
            String subject;
            String body;

            if (user.getPrize().getIsWinner()) {
                subject = "Congratulations!";
                body = "You won a prize, your number is " + user.getPrize().getId() + "! To get your prize, please come to Decebal 164, Balti Moldova.";
            } else {
                subject = "Thank You for Participating!";
                body = "Unfortunately, you did not win a prize this time. But we wait you to our Moldovan Party!";
            }

            sendEmail(email, subject, body);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void emailWinningUsers(){
        winningService.filterWinningUsers().forEach(user -> {
            sendEmail(user.getEmail(), "Congratulations!", "You won an prize, your number is" + user.getPrize().getId() + "!" +
                    " To get your prize, please come to Decebal 164, Balti Moldova");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }



    public void sendEmail(String toEmail, String subject, String body) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("rentallaptop8@gmail.com");
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            emailSender.send(message);
            System.out.println("Message sent successfully");
        }catch (MailException e){
            e.printStackTrace();
        }

    }
}
