package com.dnd.charactergenerator.controllers;

import com.vaadin.flow.router.Route;
import com.dnd.charactergenerator.services.CharacterBuilder;
import com.dnd.charactergenerator.services.MailService;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.button.Button;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dnd.charactergenerator.models.Character;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.formlayout.FormLayout;

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
     
        FormLayout formLayout = new FormLayout();

        EmailField emailField = new EmailField();
        emailField.setLabel("Email address");

        Button button = new Button("Email me!",
        event -> {
            event.getSource().setText("Clicked!!!");
            String emailAddress = emailField.getValue(); 
            mailService.dispatchEmail(emailAddress, vl); 
        });
        formLayout.add(emailField, button);
        this.add(formLayout); 
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