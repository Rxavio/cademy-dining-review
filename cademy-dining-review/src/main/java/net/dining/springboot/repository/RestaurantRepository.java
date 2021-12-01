package net.dining.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import net.dining.springboot.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
    Optional<Restaurant> findRestaurantsByNameAndZipCode(String name, String zipCode);

}