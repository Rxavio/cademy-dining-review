package net.dining.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.dining.springboot.model.DiningReview;
import net.dining.springboot.repository.RestaurantRepository;
import net.dining.springboot.repository.ReviewRepository;
import net.dining.springboot.repository.UserRepository;

@RestController
public class DiningReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/dining-review/add")
    public DiningReview createNewDiningreview(@RequestBody DiningReview diningReview){
        if(restaurantRepository.findById(diningReview.getRestaurantId()).isEmpty()){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This restaurant does not exist");
        }
        if(userRepository.findByUserName(diningReview.getReviewedBy()).isEmpty()){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user does not exist");
        }
        return reviewRepository.save(diningReview);
    }
    
    @GetMapping("/dining-review")
    public Iterable<DiningReview> getAllDiningReviews(){
        return reviewRepository.findAll();

    }

  
}
