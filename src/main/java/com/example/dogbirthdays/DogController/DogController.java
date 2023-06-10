package com.example.dogbirthdays.DogController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.dogbirthdays.entity.Dog;
import com.example.dogbirthdays.repository.DogRepository;
import java.util.List;
import java.util.Optional;

//annotation are read at compilation to add additional features or info to the program
@RestController
@RequestMapping("/dogs")
public class DogController {
    public DogRepository DOGS;
    public DogController(DogRepository DOGS){this.DOGS = DOGS;}

    @CrossOrigin
    @GetMapping()
    public List<Dog> showDog() { return DOGS.findAll();}

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Dog> showID(@PathVariable int id) {
        return DOGS.findById(id);
    }

    //POST Route
    @CrossOrigin
    @PostMapping
    public List<Dog> createDog(@RequestBody Dog newDog){
        DOGS.save(newDog);
        return DOGS.findAll();
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public Optional<Dog> updateDog(@RequestBody Dog updatedDog, @PathVariable int id){
        DOGS.findById(id)
                .map(dog ->{
                    dog.set_name(updatedDog.get_name());
                    dog.set_birthday(updatedDog.get_birthday());
                    return DOGS.save(dog);
                })
                .orElseGet(() -> {
                    return DOGS.save(updatedDog);
                });
        return DOGS.findById(id);
    }

}
