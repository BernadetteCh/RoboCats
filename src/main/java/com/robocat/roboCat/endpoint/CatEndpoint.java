package com.robocat.roboCat.endpoint;

import com.robocat.roboCat.model.Cat;
import com.robocat.roboCat.service.CatCreator;
import com.robocat.roboCat.service.CatStorage;
import com.robocat.roboCat.service.RandomProvider;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatEndpoint {
    private final CatStorage catStorage;

    public CatEndpoint(CatStorage catStorage) {
        this.catStorage = catStorage;
    }

    @PostMapping
    public Cat create(@RequestBody Cat cat) {
        catStorage.create(cat);
        return cat;
    }

    @GetMapping("{name}")
        public Cat getCatByName(@PathVariable String name) throws CatNotFoundException{
            return catStorage.readOneByName(name)
                    .orElseThrow(CatNotFoundException::new);
        }


    @GetMapping
    public List<Cat> readAll() {
        return catStorage.readAll();
    }

    @GetMapping("/randomCats")
    public List<Cat> readRandomGeneratedCat() {
        RandomProvider randomProvider = new RandomProvider();
        CatCreator catCreator = new CatCreator(randomProvider);
        catStorage.addRandomlyCreatedCatToList(catCreator);
        return catStorage.readAllRandomGeneratedCats();
    }

    @PatchMapping
    public Cat update(@RequestBody Cat cat) {
        return catStorage.update(cat);
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable String name) {
        catStorage.delete(name);
    }

}
