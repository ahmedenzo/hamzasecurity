package com.securityEcommerce.Utils;

import com.securityEcommerce.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
private JavaMailSender javaMailSender;
    public void sendSimpleMessage(final Email email)
    {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        message.setTo(email.getTo());
        javaMailSender.send(message);

    }
}
