package com.robocat.roboCat.service;

import com.robocat.roboCat.model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        cats.add(catCreator.createRandomCats());
        randomGeneratedCats.add(catCreator.createRandomCats());
    }
    public List<Cat> readAllRandomGeneratedCats() {
        return randomGeneratedCats;
    }

    public Cat update(Cat cat) {
        delete(cat.name());
        cats.add(cat);
        return cat;
    }

    public Optional<Cat> readFirstByName(String name) {
       return cats.stream()
                .filter(cat -> cat.name().equals(name)).findFirst();
    }

    public void delete(String name) {
        cats.removeIf(existing->existing.name().equals(name));
    }
}
