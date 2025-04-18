package com.dnd.charactergenerator.services;

import org.springframework.stereotype.Service;

import com.dnd.charactergenerator.utils.Constants;
import com.dnd.charactergenerator.utils.RandomNumberGenerator;
import com.dnd.charactergenerator.models.Language;
import com.dnd.charactergenerator.models.Character;
import com.dnd.charactergenerator.models.Race;
import com.dnd.charactergenerator.models.Alignment;
import java.util.*;
import java.util.function.Function;

@Service
public class CharacterBuilder {

    private RandomNumberGenerator randomNumberGenerator;
    
    HashMap<Race,Function<Character, Character>> builderMap = new HashMap<>() {{
        put(Race.HUMAN, c -> buildHumanCharacter(c)); 
        put(Race.ELF,(Character c) -> buildElvenCharacter(c)); 
        put(Race.DWARF,(Character c) -> buildDwarvenCharacter(c)); 
        put(Race.HALFLING,(Character c) -> buildHalflingCharacter(c)); 
        put(Race.HALF_ELF,(Character c) -> buildHalfElfCharacter(c)); 
        put(Race.HALF_ORC,(Character c) -> buildHalfOrcCharacter(c)); 
        put(Race.GNOME,(Character c) -> buildGnomishCharacter(c)); 
        put(Race.DRAGON_BORN,(Character c) -> buildDragonBornCharacter(c)); 
        put(Race.TIEFLING,(Character c) -> buildTieflingCharacter(c)); 
    }}; 

    public CharacterBuilder(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Character generateCharacter() {
        Character rawCharacter = Character.builder()
                .strength(getAttribute())
                .intelligence(getAttribute())
                .wisdom(getAttribute())
                .dexterity(getAttribute())
                .constitution(getAttribute())
                .charisma(getAttribute())
                .race(getRace())
                .alignment(getAlignment())
                .build();

        return modifyCharacter(rawCharacter);
    }

    private int getAttribute() {
        int[] bigList = new int[4];
        bigList[0] = randomNumberGenerator.rollDie(6);
        bigList[1] = randomNumberGenerator.rollDie(6);
        bigList[2] = randomNumberGenerator.rollDie(6);
        bigList[3] = randomNumberGenerator.rollDie(6);

        Arrays.sort(bigList);

        return bigList[1] + bigList[2] + bigList[3];
    }

    private Race getRace() {

        int randomNumber = randomNumberGenerator.rollDie(20);
        Race race;
        switch (randomNumber) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9:
                race = Race.HUMAN;
                break;
            case 10, 11:
                race = Race.ELF;
                break;
            case 12, 13:
                race = Race.DWARF;
                break;
            case 14, 15:
                race = Race.HALFLING;
                break;
            case 16:
                race = Race.HALF_ELF;
                break;
            case 17:
                race = Race.HALF_ORC;
                break;
            case 18:
                race = Race.GNOME;
                break;
            case 19:
                race = Race.DRAGON_BORN;
                break;
            case 20:
                race = Race.TIEFLING;
                break;
            default:
                race = Race.HUMAN;
        }
        return race;
    }

    private List<Language> getLanguage(List<Language> alreadyHas){

        List<Language> possibleLanguages = List.of(Language.values())
            .stream()
            .filter(l -> !alreadyHas.contains(l))
            .toList();

        List<Language> languageList = new ArrayList<>(alreadyHas); 
        int index = randomNumberGenerator.getIndex(possibleLanguages.size());
        languageList.add(possibleLanguages.get(index)); 

        return languageList;
    }

    Character modifyCharacter(Character rawCharacter) {
        Race race = rawCharacter.getRace(); 
        Function<Character, Character> method = builderMap.get(race); 
        return method.apply(rawCharacter); 
    }

    Alignment getAlignment() {
        int index = randomNumberGenerator.getIndex(9);
        return Alignment.values()[index];
    }

    Character buildHumanCharacter(Character rawCharacter) {
        return Character.builder()
                .strength(Math.min(rawCharacter.getStrength() + 1, Constants.HUMAN_MAX))
                .intelligence(Math.min(rawCharacter.getIntelligence() + 1, Constants.HUMAN_MAX))
                .wisdom(Math.min(rawCharacter.getWisdom() + 1, Constants.HUMAN_MAX))
                .dexterity(Math.min(rawCharacter.getDexterity() + 1, Constants.HUMAN_MAX))
                .constitution(Math.min(rawCharacter.getConstitution() + 1, Constants.HUMAN_MAX))
                .charisma(Math.min(rawCharacter.getCharisma() + 1, Constants.HUMAN_MAX))
                .race(rawCharacter.getRace())
                .traits(Collections.emptyList())
                .languages(getLanguage(Constants.HUMAN_LANGUAGES))
                .alignment(rawCharacter.getAlignment())
                .build();
    }

    Character buildElvenCharacter(Character rawCharacter) {
        return Character.builder()
                .strength(rawCharacter.getStrength())
                .intelligence(rawCharacter.getIntelligence())
                .wisdom(rawCharacter.getWisdom())
                .dexterity(Math.min(rawCharacter.getDexterity() + 2, Constants.ELVEN_MAX))
                .constitution(rawCharacter.getConstitution())
                .charisma(rawCharacter.getCharisma())
                .race(rawCharacter.getRace())
                .traits(Constants.ELVEN_TRAITS)
                .languages(Constants.ELVEN_LANGUAGES)
                .alignment(rawCharacter.getAlignment())
                .build();
    }

    Character buildDwarvenCharacter(Character rawCharacter) {
        return Character.builder()
                .strength(rawCharacter.getStrength())
                .intelligence(rawCharacter.getIntelligence())
                .wisdom(rawCharacter.getWisdom())
                .dexterity(rawCharacter.getDexterity())
                .constitution(Math.min(rawCharacter.getConstitution() + 2, Constants.DWARVEN_MAX))
                .charisma(rawCharacter.getCharisma())
                .race(rawCharacter.getRace())
                .traits(Constants.DWARVEN_TRAITS)
                .languages(Constants.DWARVEN_LANGUAGES)
                .alignment(rawCharacter.getAlignment())
                .build();
    }

    Character buildHalflingCharacter(Character rawCharacter) {
        return Character.builder()
                .strength(rawCharacter.getStrength())
                .intelligence(rawCharacter.getIntelligence())
                .wisdom(rawCharacter.getWisdom())
                .dexterity(Math.min(rawCharacter.getDexterity() + 2, Constants.HALFLING_MAX))
                .constitution(rawCharacter.getConstitution())
                .charisma(rawCharacter.getCharisma())
                .race(rawCharacter.getRace())
                .traits(Constants.HALFLING_TRAITS)
                .languages(Constants.HALFLING_LANGUAGES)
                .alignment(rawCharacter.getAlignment())
                .build();
    }

    Character buildHalfElfCharacter(Character rawCharacter) {

        List<Integer> halfElfBonus = Arrays.asList(1,1,0,0,0,0); 
        int seed = randomNumberGenerator.rollDie(1000);
        Collections.shuffle(halfElfBonus, new Random(seed));

        return Character.builder()
                .strength(rawCharacter.getStrength() + halfElfBonus.get(0))
                .intelligence(Math.min(rawCharacter.getIntelligence() + 1 + halfElfBonus.get(1), Constants.HALF_ELF_MAX))
                .wisdom(rawCharacter.getWisdom()+ halfElfBonus.get(2))
                .dexterity(rawCharacter.getDexterity()+ halfElfBonus.get(3))
                .constitution(rawCharacter.getConstitution()+ halfElfBonus.get(4))
                .charisma(Math.min(rawCharacter.getCharisma() + 2 + halfElfBonus.get(5), Constants.HALF_ELF_MAX))
                .race(rawCharacter.getRace())
                .traits(Constants.HALF_ELF_TRAITS)
                .languages(getLanguage(Constants.HALF_ELF_LANGUAGES))
                .alignment(rawCharacter.getAlignment())
                .build();
    }

    Character buildHalfOrcCharacter(Character rawCharacter) {
        return Character.builder()
                .strength(Math.min(rawCharacter.getStrength() + 2, Constants.HALF_ORC_MAX))
                .intelligence(rawCharacter.getIntelligence())
                .wisdom(rawCharacter.getWisdom())
                .dexterity(rawCharacter.getDexterity())
                .constitution(Math.min(rawCharacter.getConstitution() + 1, Constants.HALF_ORC_MAX))
                .charisma(rawCharacter.getCharisma())
                .race(rawCharacter.getRace())
                .traits(Constants.HALF_ORC_TRAITS)
                .languages(Constants.HALF_ORC_LANGUAGES)
                .alignment(rawCharacter.getAlignment())
                .build();
    }

    Character buildGnomishCharacter(Character rawCharacter) {
        return Character.builder()
        .strength(rawCharacter.getStrength())
        .intelligence(Math.min(rawCharacter.getIntelligence() + 2, Constants.GNOMISH_MAX))
        .wisdom(rawCharacter.getWisdom())
        .dexterity(rawCharacter.getDexterity())
        .constitution(rawCharacter.getConstitution())
        .charisma(rawCharacter.getCharisma())
        .race(rawCharacter.getRace())
        .traits(Constants.GNOMISH_TRAITS)
        .languages(Constants.GNOMISH_LANGUAGES)
        .alignment(rawCharacter.getAlignment())
        .build();
    }

    Character buildDragonBornCharacter(Character rawCharacter) {
        return Character.builder()
        .strength(Math.min(rawCharacter.getStrength() + 2, Constants.DRAGON_BORN_MAX))
        .intelligence(rawCharacter.getIntelligence())
        .wisdom(rawCharacter.getWisdom())
        .dexterity(rawCharacter.getDexterity())
        .constitution(rawCharacter.getConstitution())
        .charisma(Math.min(rawCharacter.getCharisma() + 1, Constants.DRAGON_BORN_MAX))
        .race(rawCharacter.getRace())
        .traits(Constants.DRAGON_BORN_TRAITS)
        .languages(Constants.DRAGON_BORN_LANGUAGES)
        .alignment(rawCharacter.getAlignment())
        .build();
    }

    Character buildTieflingCharacter(Character rawCharacter) {
        return Character.builder()
        .strength(rawCharacter.getStrength())
        .intelligence(Math.min(rawCharacter.getIntelligence()+1,Constants.TIEFLING_MAX))
        .wisdom(rawCharacter.getWisdom())
        .dexterity(rawCharacter.getDexterity()+2)
        .constitution(rawCharacter.getConstitution())
        .charisma(rawCharacter.getCharisma()+2)
        .race(rawCharacter.getRace())
        .traits(Constants.TIEFLING_TRAITS)
        .languages(Constants.TIEFLING_LANGUAGES)
        .alignment(rawCharacter.getAlignment())
        .build();

    }
}
