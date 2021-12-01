package net.dining.springboot.model;
import javax.persistence.*;
@Entity
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	

	public Integer getPeanutScore() {
		return peanutScore;
	}

	public void setPeanutScore(Integer peanutScore) {
		this.peanutScore = peanutScore;
	}

	public Integer getEggScore() {
		return eggScore;
	}

	public void setEggScore(Integer eggScore) {
		this.eggScore = eggScore;
	}

	public Integer getDairyScore() {
		return dairyScore;
	}

	public void setDairyScore(Integer dairyScore) {
		this.dairyScore = dairyScore;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public AdminReviewStatus getAdminReviewStatus() {
		return adminReviewStatus;
	}

	public void setAdminReviewStatus(AdminReviewStatus adminReviewStatus) {
		this.adminReviewStatus = adminReviewStatus;
	}
    
    

}