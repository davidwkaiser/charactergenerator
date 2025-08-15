package com.dnd.charactergenerator.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    RandomNumberGenerator subject = new RandomNumberGenerator();

    @Test
    void getDieRollWorks() {
        for (int i = 0; i < 10; i++){
            int actual = subject.rollDie(10);
            System.out.println(actual);
            assertTrue( actual >= 1 && actual <= 10);
        }
    }

    @Test
    void getIndexWorks() {
        for (int i = 0; i < 10; i++){
            int actual = subject.getIndex(10);
            System.out.println("******");
            System.out.println(actual);
            assertTrue( actual >= 0 && actual <= 9);
        }
    }
}