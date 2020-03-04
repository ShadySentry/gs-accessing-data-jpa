package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.model.Restaurant;
import com.example.accessingdatajpa.repository.RestaurantRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll(){
        List<Restaurant> restaurants = IteratorUtils.toList(restaurantRepository.findAll().iterator());
        restaurants.sort(Comparator.comparing(Restaurant::getDescription));
        return restaurants;
    }


}
