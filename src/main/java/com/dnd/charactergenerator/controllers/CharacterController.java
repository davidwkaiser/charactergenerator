package com.dnd.charactergenerator.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.lang.*;
import com.dnd.charactergenerator.services.CharacterBuilder;
import java.util.*;
import com.dnd.charactergenerator.models.Character;

@RestController
public class CharacterController {

    CharacterBuilder characterBuilder;

    public CharacterController(final CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
    }

    @GetMapping("/")
    public Character generateCharacter() {

        return characterBuilder.generateCharacter();
    }
}
