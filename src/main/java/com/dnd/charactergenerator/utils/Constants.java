package com.dnd.charactergenerator.utils;

import java.util.List;

import com.dnd.charactergenerator.models.Language;

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

    public static final List<Language> HUMAN_LANGUAGES = List.of(Language.values()[0]); 

    public static final List<String> ELVEN_TRAITS = List.of("Darkvision", "Keen Senses", "Fey Ancestry", "Trance");
    public static final List<Language> ELVEN_LANGUAGES = List.of(Language.values()[0], Language.values()[1]);

    public static final List<String> DWARVEN_TRAITS = List.of("Darkvision", "Dwarven Resilience",
            "Dwarven Combat Training", "Stonecunning");
    public static final List<Language> DWARVEN_LANGUAGES = List.of(Language.values()[0], Language.values()[2]);

    public static final List<String> HALFLING_TRAITS = List.of("Darkvision", "Fey Ancestry", "CHOOSE ONE SKILL");
    public static final List<Language> HALFLING_LANGUAGES = List.of(Language.values()[0], Language.values()[3]);

    public static final List<Language> HALF_ELF_LANGUAGES = List.of(Language.values()[0], Language.values()[1]);

    public static final List<String> HALF_ORC_TRAITS = List.of("Darkvision", "Menacing", "Relentless Endurance",
            "Savage Attacks");
    public static final List<Language> HALF_ORC_LANGUAGES = List.of(Language.values()[1], Language.values()[4]);

    public static final List<String> GNOMISH_TRAITS = List.of("Darkvision", "Gnome Cunning");
    public static final List<Language> GNOMISH_LANGUAGES = List.of(Language.values()[0], Language.values()[5]);

    public static final List<String> DRAGON_BORN_TRAITS = List.of("Draconic Ancestry", "Breath Weapon",
            "Damage Resistence");
    public static final List<Language> DRAGON_BORN_LANGUAGES = List.of(Language.values()[0], Language.values()[6]);

    public static final List<String> TIEFLING_TRAITS = List.of("Darkvision", "Infernal Legacy", "Hellish Resistence");
    public static final List<Language> TIEFLING_LANGUAGES = List.of(Language.values()[0], Language.values()[7]); 

}
