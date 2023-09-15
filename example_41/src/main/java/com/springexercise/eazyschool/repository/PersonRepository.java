package com.springexercise.eazyschool.repository;

import com.springexercise.eazyschool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);
}
