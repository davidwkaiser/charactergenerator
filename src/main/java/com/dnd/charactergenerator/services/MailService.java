package com.dnd.charactergenerator.services;

import org.springframework.stereotype.Service;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Service
public class MailService {

    String apiKey; 
    String railgunSandboxDomain; 

    public MailService(){
        this.apiKey = System.getenv("MAILGUN_TOKEN");
        this.railgunSandboxDomain = System.getenv("MAILGUN_DOMAIN"); 
    }

    public void sendMail(){
        System.out.println("mail sent!"); 
    }

public void dispatchEmail(
    String emailAddress,
    VerticalLayout html
    ) {

        MailgunMessagesApi mailgunMessagesApi = MailgunClient // RIGHT HERE
            .config(apiKey)
            .createApi(MailgunMessagesApi.class);

        Message message = Message.builder()
            .from("davidwkaiser@gmail.com")
            .to(emailAddress)
            .subject("Your DnD Character")
            .html(html.getElement().getOuterHTML())
            .build();

        MessageResponse messageResponse = mailgunMessagesApi.sendMessage(railgunSandboxDomain, message);

        System.out.println(messageResponse); 
    }
}
