package net.dining.springboot.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.dining.springboot.model.AdminReviewStatus;
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
    
    @GetMapping("/dining-review/pending")
    public Iterable<DiningReview> getPendingReviews(){
        return reviewRepository.findByAdminReviewStatus(AdminReviewStatus.PENDING);
    }
    
    @GetMapping("/dining-review/approved")
    public Iterable<DiningReview> getApprovedReviews(){
        return reviewRepository.findByAdminReviewStatus(AdminReviewStatus.APPROVED);
    }
    
    @GetMapping("/dining-review/rejected")
    public Iterable<DiningReview> getRejectedReviews(){
        return reviewRepository.findByAdminReviewStatus(AdminReviewStatus.REJECTED);
    }
    
    @GetMapping("/dining-review/approved/{id}")
    public Iterable<DiningReview> getApprovedReviewById(@PathVariable("id") Long id){
        return reviewRepository.findByIdAndAdminReviewStatus(id, AdminReviewStatus.APPROVED);
    }
    
    @GetMapping("/dining-review/pending/{id}")
    public Iterable<DiningReview> getPendingReviewById(@PathVariable("id") Long id){
        return reviewRepository.findByIdAndAdminReviewStatus(id, AdminReviewStatus.PENDING);
    }
    
    @GetMapping("/dining-review/rejected/{id}")
    public Iterable<DiningReview> getRejectedReviewById(@PathVariable("id") Long id){
        return reviewRepository.findByIdAndAdminReviewStatus(id, AdminReviewStatus.REJECTED);
    }
    
    @PutMapping("/dining-review/{id}/approve")
    public DiningReview approveReview(@PathVariable("id") Long id){
        Optional<DiningReview> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist");
        }
        DiningReview reviewToApprove = reviewOptional.get();
        reviewToApprove.setAdminReviewStatus(AdminReviewStatus.APPROVED);
        return reviewRepository.save(reviewToApprove);
    }
    
    @PutMapping("/dining-review/{id}/reject")
    public DiningReview rejectReview(@PathVariable("id") Long id){
        Optional<DiningReview> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist");
        }
        DiningReview reviewToReject = reviewOptional.get();
        reviewToReject.setAdminReviewStatus(AdminReviewStatus.REJECTED);
        return reviewRepository.save(reviewToReject);
    }

  
}
