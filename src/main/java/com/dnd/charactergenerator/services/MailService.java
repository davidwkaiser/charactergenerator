package com.dnd.charactergenerator.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content; 
import com.sendgrid.helpers.mail.objects.Email;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Service
public class MailService {

    private static final String EMAIL_ENDPOINT = "mail/send";

    public MailService(){
    }

    public void sendMail(){
        System.out.println("mail sent!"); 
    }

public void dispatchEmail(
    String emailAddress,
    VerticalLayout html
    ) {
    Email from = new Email("davidwkaiser@gmail.com");
    String subject = "Test for the DnD site";
    Email to = new Email(emailAddress);

    Content content = new Content("text/html", html.getElement().getOuterHTML());
  
    Mail mail = new Mail(from, subject, to, content);

    // SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    SendGrid sg = new SendGrid("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");
    Request request = new Request();
      try {
        request.setMethod(Method.POST);
        request.setEndpoint(EMAIL_ENDPOINT);
        request.setBody(mail.build());
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
      } catch (IOException ex) {
        System.out.println(ex); 
      }
    }
}
