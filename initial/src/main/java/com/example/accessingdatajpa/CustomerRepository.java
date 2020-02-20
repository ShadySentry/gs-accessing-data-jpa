package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Person, Long> {
    List<Person> findByLastName(String lastName);

    Person findById(long id);
}
