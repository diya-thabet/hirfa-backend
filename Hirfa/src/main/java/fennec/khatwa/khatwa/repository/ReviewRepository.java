package fennec.khatwa.khatwa.repository;


import fennec.khatwa.khatwa.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}