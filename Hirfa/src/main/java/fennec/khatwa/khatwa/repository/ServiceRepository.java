package fennec.khatwa.khatwa.repository;

import fennec.khatwa.khatwa.model.ServiceOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceOffer, Long> {
}