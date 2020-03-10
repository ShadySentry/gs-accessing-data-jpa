package com.example.accessingdatajpa.repository;

import java.util.List;
import java.util.Optional;

import com.example.accessingdatajpa.model.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

	List<Meal> findByDescription(String description);

//	Meal findById(Integer id);

	Optional<Meal> findById(Long id);

	@Query("select m FROM Meal m join fetch Restaurant where m.id = ?1")
	Meal getWithRestaurants(Long id);


}
