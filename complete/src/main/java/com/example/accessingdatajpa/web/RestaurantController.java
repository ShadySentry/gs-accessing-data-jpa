package com.example.accessingdatajpa.web;

import com.example.accessingdatajpa.AccessingDataJpaApplication;
import com.example.accessingdatajpa.model.Restaurant;
import com.example.accessingdatajpa.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurants")
    public @ResponseBody List<Restaurant> getRestaurants(){
        return restaurantService.getAll();
    }

    @GetMapping(value = "/restaurants/{id}")
    public @ResponseBody Restaurant getRestaurantById(@PathVariable Long id){
        log.info("/restaurants/{id}");
        return null;
    }

    @GetMapping(value = "/restaurants/priceRange")
    public List<Restaurant> getPriceRange(
            @RequestParam(required = false)Integer minPrice,
            @RequestParam(required = false)Integer maxPrice){
        log.info("/restaurants/priceRange");
        return null;
    }

}
