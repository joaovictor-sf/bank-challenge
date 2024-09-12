package com.joaovictor.bank.repositories;

import com.joaovictor.bank.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
