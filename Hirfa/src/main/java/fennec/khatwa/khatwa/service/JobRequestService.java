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

import java.util.List;

@Service
public class JobRequestService {

    @Autowired
    private JobRequestRepository jobRequestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public JobRequest createJobRequest(JobRequestDTO jobRequestDTO) {
        User user = userRepository.findById(jobRequestDTO.getUserId()).orElseThrow();
        ServiceOffer service = serviceRepository.findById(jobRequestDTO.getServiceId()).orElseThrow();
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