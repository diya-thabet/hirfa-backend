package fennec.khatwa.khatwa.service;


import fennec.khatwa.khatwa.dto.JobOfferDTO;
import fennec.khatwa.khatwa.model.JobOffer;
import fennec.khatwa.khatwa.model.JobRequest;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.repository.JobOfferRepository;
import fennec.khatwa.khatwa.repository.JobRequestRepository;
import fennec.khatwa.khatwa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private JobRequestRepository jobRequestRepository;

    @Autowired
    private UserRepository userRepository;

    public JobOffer createJobOffer(JobOfferDTO jobOfferDTO) {
        JobRequest jobRequest = jobRequestRepository.findById(jobOfferDTO.getJobRequestId()).orElseThrow();
        User freelancer = userRepository.findById(jobOfferDTO.getFreelancerId()).orElseThrow();
        JobOffer jobOffer = new JobOffer();
        jobOffer.setJobRequest(jobRequest);
        jobOffer.setFreelancer(freelancer);
        jobOffer.setPrice(jobOfferDTO.getPrice());
        return jobOfferRepository.save(jobOffer);
    }

    public List<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }
}