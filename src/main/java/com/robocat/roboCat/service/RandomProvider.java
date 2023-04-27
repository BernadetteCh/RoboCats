package com.robocat.roboCat.service;
import java.util.Random;

public class RandomProvider {

    public int createRandomIndex(int length) {
        Random random = new Random();
        int randomIndex = random.nextInt(length);
        return randomIndex;
    }
}
