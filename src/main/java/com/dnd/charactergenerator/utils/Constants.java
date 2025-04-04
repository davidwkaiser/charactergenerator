package com.dnd.charactergenerator.utils;

import java.util.List;

public class Constants {
    public static final int HUMAN_MAX = 18;
    public static final int HUMAN_MIN = 3;
    public static final int ELVEN_MAX = 18;
    public static final int DWARVEN_MAX = 18;
    public static final int HALFLING_MAX = 18;
    public static final int HALF_ELF_MAX = 18;
    public static final int HALF_ORC_MAX = 18;
    public static final int GNOMISH_MAX = 18;
    public static final int DRAGON_BORN_MAX = 18;
    public static final int TIEFLING_MAX = 18;

    public static final List<String> LANGUAGES = List.of(
        "Common", 
        "Elvish", 
        "Dwarvish", 
        "Halfling", 
        "Orc", 
        "Gnomish", 
        "Draconic", 
        "Infernal"
        );

    public static final List<String> HUMAN_LANGUAGES = List.of(LANGUAGES.get(0)); 

    public static final List<String> ELVEN_TRAITS = List.of("Darkvision", "Keen Senses", "Fey Ancestry", "Trance");
    public static final List<String> ELVEN_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(1));

    public static final List<String> DWARVEN_TRAITS = List.of("Darkvision", "Dwarven Resilience",
            "Dwarven Combat Training", "Stonecunning");
    public static final List<String> DWARVEN_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(2));

    public static final List<String> HALFLING_TRAITS = List.of("Darkvision", "Fey Ancestry", "CHOOSE ONE SKILL");
    public static final List<String> HALFLING_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(3));

    public static final List<String> HALF_ORC_TRAITS = List.of("Darkvision", "Menacing", "Relentless Endurance",
            "Savage Attacks");
    public static final List<String> HALF_ORC_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(4));

    public static final List<String> GNOMISH_TRAITS = List.of("Darkvision", "Gnome Cunning");
    public static final List<String> GNOMISH_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(5));

    public static final List<String> DRAGON_BORN_TRAITS = List.of("Draconic Ancestry", "Breath Weapon",
            "Damage Resistence");
    public static final List<String> DRAGON_BORN_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(6));

    public static final List<String> TIEFLING_TRAITS = List.of("Darkvision", "Infernal Legacy", "Hellish Resistence");
    public static final List<String> TIEFLING_LANGUAGES = List.of(LANGUAGES.get(0), LANGUAGES.get(7)); 

}
