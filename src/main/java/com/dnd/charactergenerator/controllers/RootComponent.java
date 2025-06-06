package com.dnd.charactergenerator.controllers;

import com.vaadin.flow.router.Route;
import com.dnd.charactergenerator.services.CharacterBuilder;
import com.vaadin.flow.component.html.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.dnd.charactergenerator.models.Character;
import com.dnd.charactergenerator.models.Language;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


// import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;

@Route("")
@StyleSheet("dk-styles.css")
public class RootComponent extends VerticalLayout {

    public RootComponent(@Autowired CharacterBuilder characterBuilder){
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

        this.add(div); 
        this.add(new Span("Race: "+character.getRace()));
        this.add(new Span("Alignment: "+character.getAlignment()));
        this.add(new Span("Languages: "+prettifyList(character.getLanguages())));
        this.add(new Span("Traits: "+prettifyList(character.getTraits())));
        this.add(new Span("Size: "+character.getSize()));
        this.add(new Span("Speed: "+character.getSpeed()));
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