package com.robocat.roboCat.service;

import com.robocat.roboCat.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatStorage {
    private final List<Cat> cats;
    private final List<Cat> randomGeneratedCats = new ArrayList<>();

    public CatStorage(List<Cat> cats) {
        this.cats = cats;
    }
    public void create(Cat cat) {
        cats.add(cat);
    }
    public List<Cat> readAll() {
        return cats;
    }
    public void addRandomlyCreatedCatToList(CatCreator catCreator) {
        cats.add(catCreator.createRandomCat());
        randomGeneratedCats.add(catCreator.createRandomCat());
    }
    public List<Cat> readAllRandomGeneratedCats() {
        return randomGeneratedCats;
    }

    public Cat update(Cat cat) {
        delete(cat.name());
        cats.add(cat);
        return cat;
    }

    private void delete(String name) {
        cats.removeIf(existing->existing.name().equals(name));
    }
}
