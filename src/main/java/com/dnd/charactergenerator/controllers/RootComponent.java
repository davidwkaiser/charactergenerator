package com.dnd.charactergenerator.controllers;

import com.vaadin.flow.router.Route;
import com.dnd.charactergenerator.services.CharacterBuilder;
import com.dnd.charactergenerator.services.MailService;

import com.vaadin.flow.component.html.*;

import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

import org.springframework.beans.factory.annotation.Autowired;

import com.dnd.charactergenerator.models.Character;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.textfield.EmailField;

@Route("")
@StyleSheet("dk-styles.css")
public class RootComponent extends VerticalLayout {

    public RootComponent(
            @Autowired CharacterBuilder characterBuilder,
            @Autowired MailService mailService
        ){
        Character character = characterBuilder.generateCharacter();

        this.add(new H3("Your newly generated character:"));
        Div div = new Div(); 
        div.add(new Span("Attributes")); 
        UnorderedList ul = new UnorderedList();
        ul.add(new ListItem("Strength: "+character.getStrength()));
        ul.add(new ListItem("Intelligence: "+character.getIntelligence()));
        ul.add(new ListItem("Wisdom: "+character.getWisdom()));
        ul.add(new ListItem("Constitution: "+character.getConstitution()));
        ul.add(new ListItem("Charisma: "+character.getCharisma()));
        ul.add(new ListItem("Constitution: "+character.getConstitution()));

        ul.addClassName("pickleJuice"); 

        div.add(ul);

        VerticalLayout vl = new VerticalLayout();    
        
        vl.add(div); 

        vl.add(new Paragraph("Race: "+character.getRace() + "\n"));
        vl.add(new Paragraph("Alignment: "+character.getAlignment() + "\n"));
        vl.add(new Paragraph("Languages: "+prettifyList(character.getLanguages()) + "\n"));
        vl.add(new Paragraph("Traits: "+prettifyList(character.getTraits()) + "\n"));
        vl.add(new Paragraph("Size: "+character.getSize() + "\n"));
        vl.add(new Paragraph("Speed: "+character.getSpeed()+ "\n"));

        this.add(vl); 
     
        EmailField emailField = new EmailField();
        emailField.setLabel("Email address");
        emailField.focus(); 

        emailField.addKeyDownListener(com.vaadin.flow.component.Key.ENTER, event -> {
                String emailAddress = emailField.getValue(); 
                mailService.dispatchEmail(emailAddress, vl); 
                Notification notification = Notification.show("Sent!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                notification.setDuration(50);
                emailField.clear();
        });
        this.add(emailField); 
    }

    private String prettifyList(List<?> list){

        Optional<String> combinedString = list
            .stream()
            .map(x -> x.toString())
            .map(this::capitalize)
            .reduce((str1, str2) -> str1 + ", " + str2);
        return combinedString.isPresent() ? combinedString.get() : "";  
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}