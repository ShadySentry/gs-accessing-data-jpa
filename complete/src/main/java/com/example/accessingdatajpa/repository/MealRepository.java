package com.example.accessingdatajpa.repository;

import java.util.List;

import com.example.accessingdatajpa.model.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

	List<Meal> findByDescription(String description);

	Meal findById(Integer id);
}
