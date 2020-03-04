package com.example.accessingdatajpa.web;

import com.example.accessingdatajpa.model.Restaurant;
import com.example.accessingdatajpa.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurant")
    public @ResponseBody List<Restaurant> getRestaurants(){
        return restaurantService.getAll();
    }
}
