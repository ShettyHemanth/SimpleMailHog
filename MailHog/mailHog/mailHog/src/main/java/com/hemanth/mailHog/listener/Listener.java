package com.hemanth.mailHog.listener;

import com.hemanth.mailHog.config.EmailConfig;
import com.hemanth.mailHog.model.Student;
import com.hemanth.mailHog.mailService.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listener
{

    @Autowired
    MailService mailService;

    @RabbitListener(queues = EmailConfig.login_queue)
    public void consumeMessageFromQueue(Student student)
    {

        System.out.println(student.getEmail());

        String emailTo = student.getEmail();

        System.out.println("Sending email");
        mailService.sendMessage(emailTo);
        System.out.println("Done");
    }



}
