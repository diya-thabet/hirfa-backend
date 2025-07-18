package fennec.khatwa.khatwa.repository;

import fennec.khatwa.khatwa.model.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRequestRepository extends JpaRepository<JobRequest, Long> {
}