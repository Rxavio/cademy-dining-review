package net.dining.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/restaurants/{id}")
    public Optional<Restaurant> getRestaurantBy(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This restaurant does not exist");
        }
        return restaurantRepository.findById(id);
    }
    
    @GetMapping("/restaurants/byname")
    public List<Restaurant> searchRestaurant(
      @RequestParam(name = "name", required = false) String name
    ) {
      if (name != null) {
     return this.restaurantRepository.findByName(name);
      } 
      else {
        return new ArrayList<>();
      }
    }
    
}
