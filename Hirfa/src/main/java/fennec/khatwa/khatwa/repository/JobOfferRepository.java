package fennec.khatwa.khatwa.repository;

import fennec.khatwa.khatwa.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}