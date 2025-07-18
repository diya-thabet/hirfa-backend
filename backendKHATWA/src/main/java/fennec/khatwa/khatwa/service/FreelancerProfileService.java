package fennec.khatwa.khatwa.service;

import fennec.khatwa.khatwa.model.FreelancerProfile;
import fennec.khatwa.khatwa.repository.FreelancerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerProfileService {

    @Autowired
    private FreelancerProfileRepository freelancerProfileRepository;

    public FreelancerProfile createFreelancerProfile(FreelancerProfile profile) {
        return freelancerProfileRepository.save(profile);
    }

    public List<FreelancerProfile> getAllFreelancerProfiles() {
        return freelancerProfileRepository.findAll();
    }
}