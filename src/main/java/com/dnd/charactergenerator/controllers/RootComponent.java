package com.dnd.charactergenerator.controllers;

import com.vaadin.flow.router.Route;
import com.dnd.charactergenerator.services.CharacterBuilder;
import com.vaadin.flow.component.html.Div;
import org.springframework.beans.factory.annotation.Autowired;
import com.dnd.charactergenerator.models.Character;


@Route("")
public class RootComponent extends Div {

    public RootComponent(@Autowired CharacterBuilder characterBuilder){
        Character character = characterBuilder.generateCharacter();
        setText(character.toString());
    }
}