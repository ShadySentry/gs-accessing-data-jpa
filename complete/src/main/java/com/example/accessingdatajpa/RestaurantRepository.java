package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
    List<Restaurant> findByDescription(String description);

    Optional<Restaurant> findById(Long id);
}
