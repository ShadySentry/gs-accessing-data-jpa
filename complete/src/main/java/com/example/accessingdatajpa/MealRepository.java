package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Long> {

	List<Meal> findByDescription(String description);

	Meal findById(Integer id);
}
