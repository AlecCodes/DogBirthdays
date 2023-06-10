package com.example.dogbirthdays.repository;

import com.example.dogbirthdays.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA repository is like DjangoRESTFramework. Its an ORM wrapper that maps POJOs to table rows,
// and also provides CRUD operations to be executed against the DB.

public interface DogRepository extends JpaRepository <Dog, Integer>{
}
