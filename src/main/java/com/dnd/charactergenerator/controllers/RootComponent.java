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


@Route("")
public class RootComponent extends VerticalLayout {

    public RootComponent(@Autowired CharacterBuilder characterBuilder){
        Character character = characterBuilder.generateCharacter();
        this.add(new H2("Your newly generated character:"));
        this.add(new Paragraph("Race: "+character.getRace()));
        this.add(new Paragraph("Strength: "+character.getStrength()));
        this.add(new Paragraph("Intelligence: "+character.getIntelligence()));
        this.add(new Paragraph("Wisdom: "+character.getWisdom()));
        this.add(new Paragraph("Constitution: "+character.getConstitution()));
        this.add(new Paragraph("Charisma: "+character.getCharisma()));
        this.add(new Paragraph("Constitution: "+character.getConstitution()));
        this.add(new Paragraph("Alignment: "+character.getAlignment()));
        this.add(new Paragraph("Languages: "+prettifyLanguages(character.getLanguages())));
        this.add(new Paragraph("Traits: "+character.getTraits()));
    }

    private String prettifyLanguages(List<Language> languages){

        Optional<String> combinedString = languages
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