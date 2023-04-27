package com.robocat.roboCat.service;

import com.robocat.roboCat.model.BreedType;
import com.robocat.roboCat.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatCreator {
    private final RandomProvider randomProvider;

    public CatCreator(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Cat createRandomCats() {
        return new Cat(randomProvider.createRandomIndex(20), generateRandomName(), generateRandomBreed());
    }

    private String generateRandomName() {
        String[] catNames = {"Lacky", "Speedy", "Whiskers", "Mufasa", "Fluffy"};
        int randomIndex = randomProvider.createRandomIndex(catNames.length);
        return catNames[randomIndex];
    }

    private String generateRandomBreed() {
        BreedType breedTypeEnum[] = BreedType.values();
        int randomIndex = randomProvider.createRandomIndex(breedTypeEnum.length);
        return breedTypeEnum[randomIndex].toString();
    }
}
