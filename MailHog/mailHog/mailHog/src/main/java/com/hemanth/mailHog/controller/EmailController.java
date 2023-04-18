package com.hemanth.mailHog.controller;

import com.hemanth.mailHog.config.EmailConfig;
import com.hemanth.mailHog.model.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EmailController
{
    @Autowired
    RabbitTemplate rbt;
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public String sendMessage(@RequestBody Student st)
    {



        rbt.convertAndSend(EmailConfig.topic_exchange,EmailConfig.routing_Key,st);

        return "Data Added successfully";
    }

}
