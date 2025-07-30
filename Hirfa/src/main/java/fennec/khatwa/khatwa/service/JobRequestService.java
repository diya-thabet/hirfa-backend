package fennec.khatwa.khatwa.service;

import fennec.khatwa.khatwa.dto.JobRequestDTO;
import fennec.khatwa.khatwa.model.JobRequest;
import fennec.khatwa.khatwa.model.ServiceOffer;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.repository.JobRequestRepository;
import fennec.khatwa.khatwa.repository.ServiceRepository;
import fennec.khatwa.khatwa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class JobRequestService {

    private final JobRequestRepository jobRequestRepository;

    private final UserRepository userRepository;

    private final ServiceRepository serviceRepository;

    public JobRequestService(JobRequestRepository jobRequestRepository, UserRepository userRepository, ServiceRepository serviceRepository) {
        this.jobRequestRepository = jobRequestRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    public JobRequest createJobRequest(JobRequestDTO jobRequestDTO) {
        Optional<User> userOptional = userRepository.findById(jobRequestDTO.getUserId());
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + jobRequestDTO.getUserId() + " not found.");
        }
        User user = userOptional.get();

        Optional<ServiceOffer> serviceOptional = serviceRepository.findById(jobRequestDTO.getServiceId());
        if (serviceOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service with ID " + jobRequestDTO.getServiceId() + " not found.");
        }
        ServiceOffer service = serviceOptional.get();

        JobRequest jobRequest = new JobRequest();
        jobRequest.setUser(user);
        jobRequest.setService(service);
        jobRequest.setDescription(jobRequestDTO.getDescription());
        jobRequest.setStatus(jobRequestDTO.getStatus());
        return jobRequestRepository.save(jobRequest);
    }

    public List<JobRequest> getAllJobRequests() {
        return jobRequestRepository.findAll();
    }
}