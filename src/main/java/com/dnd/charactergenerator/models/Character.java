package com.dnd.charactergenerator.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Character {

    int strength;
    int intelligence;
    int wisdom;
    int dexterity;
    int constitution;
    int charisma;
    Race race;
    List<String> traits;
    List<Language> languages;
    Alignment alignment;
    Size size; 
    int speed; 
}
