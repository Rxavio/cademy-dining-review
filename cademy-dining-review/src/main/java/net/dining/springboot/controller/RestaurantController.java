package net.dining.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.dining.springboot.model.Restaurant;
import net.dining.springboot.repository.RestaurantRepository;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @PostMapping("/restaurants/add")
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
        if (restaurantRepository.existsByPostcode(restaurant.getPostcode()) && restaurantRepository.existsByName(restaurant.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A restaurant with this name and postcode already exists");
        }
        return restaurantRepository.save(restaurant);
    }
    
    @GetMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
