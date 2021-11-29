package net.dining.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "dining_review")
public class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "reviewed_by")
    private String reviewedBy;
    
    @Column(name = "restaurant_id")
    private Long restaurantId;
    
    @Column(name = "peanut_score")
    private Integer peanutScore;
    
    @Column(name = "egg_score")
    private Integer eggScore;
    
    @Column(name = "dairy_score")
    private Integer dairyScore;
    
    @Column(name = "commentary")
    private String commentary;
    
    @Column(name = "review_status")
    @Enumerated(EnumType.STRING)
    
    private AdminReviewStatus adminReviewStatus;

}