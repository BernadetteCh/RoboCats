package com.robocat.roboCat.service;

import com.robocat.roboCat.model.Cat;

import java.util.List;

public class CatStorage {
    private final List<Cat> cats;

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
