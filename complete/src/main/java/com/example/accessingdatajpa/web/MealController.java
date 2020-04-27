package com.example.accessingdatajpa.web;

import com.example.accessingdatajpa.AccessingDataJpaApplication;
import com.example.accessingdatajpa.model.Meal;
import com.example.accessingdatajpa.model.Restaurant;
import com.example.accessingdatajpa.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@RestController
//@Controller
public class MealController {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    private final MealService mealService;
    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meals")
    public @ResponseBody
    List<Meal> getAll() {
        log.info("/meals");
        return mealService.getAll();
    }

    @GetMapping("/meals/{id}")
    public Meal getMealById(@PathVariable Long id){
        notNull(id,"id cant be null");
        return mealService.getById(id).orElse(null);
    }

    @GetMapping("/meals/{description}")
    public List<Meal> getMealByDescription(@Valid @PathVariable String description){
        return mealService.getMealByDescription(description);
    }

    @GetMapping("/meals/withRestaurants/{id}")
    public List<Meal> getFilteredWithRestaurant(@RequestParam(required = false) Long id){
        mealService.getByIdWithRestaurants(id);
        return null;
    }

}
