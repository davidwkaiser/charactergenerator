package com.dnd.charactergenerator.utils;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomNumberGenerator {

    private Random randomGenerator = new Random();

    public RandomNumberGenerator() {
    }

    public int rollDie(int number){
        return randomGenerator.nextInt(number) + 1;
    }

    public int getIndex(int number){
        return randomGenerator.nextInt(number);
    }
}
