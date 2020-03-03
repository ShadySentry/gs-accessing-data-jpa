package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    public MealRepository mealRepository;
}
