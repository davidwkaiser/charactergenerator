package com.dnd.charactergenerator.models;

import lombok.Data;
import com.dnd.charactergenerator.models.Language;
import lombok.Builder;
import java.util.*;


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
}
