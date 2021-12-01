package net.dining.springboot.repository;
import org.springframework.data.repository.CrudRepository;
import net.dining.springboot.model.AdminReviewStatus;
import net.dining.springboot.model.DiningReview;

public interface ReviewRepository extends CrudRepository<DiningReview, Long> {
    Iterable<DiningReview> findByIdAndAdminReviewStatus(Long id, AdminReviewStatus status);
    Iterable<DiningReview> findByAdminReviewStatus(AdminReviewStatus pending);
}
