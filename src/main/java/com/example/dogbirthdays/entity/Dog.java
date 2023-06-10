package com.example.dogbirthdays.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DOGS")
public class Dog {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dogs_generator")
    //dogs_dog_id_seq is the value from our postgres db seq object
    @SequenceGenerator(name = "dogs_generator", sequenceName = "dogs_dog_id_seq", allocationSize = 1)
    private int dog_id;
    private String name;

    // LocalDate is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization)
    // on instances of LocalDate may have unpredictable results and should be avoided.
    // The equals method should be used for comparisons.
    private LocalDate birthday;

    public int get_id() {return dog_id;}

    public String get_name(){return name;}

    private LocalDate get_birthday(){return birthday;}

    private void set_id(int dog_id){this.dog_id = dog_id;}

    private void set_name(String name){this.name = name;}

    private void set_birthday(LocalDate birthday){this.birthday = birthday; }

}
