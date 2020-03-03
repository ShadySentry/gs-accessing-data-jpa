package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
    List<Restaurant> findByDescription(String description);

    Optional<Restaurant> findById(Long id);
}
