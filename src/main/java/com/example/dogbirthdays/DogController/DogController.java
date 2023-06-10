package com.example.dogbirthdays.DogController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.dogbirthdays.entity.Dog;
import com.example.dogbirthdays.repository.DogRepository;
import java.util.List;

//annotation are read at compilation to add additional features or info to the program
@RestController
@RequestMapping("/dogs")
public class DogController {
    public DogRepository DOGS;
    public DogController(DogRepository DOGS){this.DOGS = DOGS;}

    @CrossOrigin
    @GetMapping()
    public List<Dog> showDog() { return DOGS.findAll();}


}
