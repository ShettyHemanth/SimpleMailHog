package com.hemanth.mailHog.mailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService
{

    @Autowired
    public JavaMailSender javaMailSender;


    public void sendMessage(String s)
    {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setFrom("hemanth.shetty@cloverbaytechnologies.com");
        simpleMailMessage.setTo(s);
        simpleMailMessage.setSubject("Student Registration");
        simpleMailMessage.setText("Registration successfully completed");


        javaMailSender.send(simpleMailMessage);


    }
}
