package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.model.Meal;
import com.example.accessingdatajpa.repository.MealRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class MealService {

    public MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getAll(){
        List<Meal> meals = IteratorUtils.toList(mealRepository.findAll().iterator());
        meals.sort(Comparator.comparing(Meal::getDescription));
        return meals;
    }

    public List<Meal> getMealByDescription(String description){
        notNull(description,"description can't be null");

        List<Meal> meals = mealRepository.findByDescription(description);
        meals.sort(Comparator.comparing(Meal::getDescription));
        return meals;
    }

    public Optional<Meal> findById(Long id){
        notNull(id,"id can't be null");

        return mealRepository.findById(id);
    }

    public void removeById(Long id){
        mealRepository.deleteById(id);
    }
}
