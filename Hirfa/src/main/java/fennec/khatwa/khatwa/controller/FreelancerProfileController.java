package fennec.khatwa.khatwa.controller;

import fennec.khatwa.khatwa.dto.FreelancerProfileDTO;
import fennec.khatwa.khatwa.model.FreelancerProfile;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.service.FreelancerProfileService;
import fennec.khatwa.khatwa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/freelancer-profiles")
public class FreelancerProfileController {

    private final FreelancerProfileService freelancerProfileService;

    private final UserRepository userRepository;

    public FreelancerProfileController(FreelancerProfileService freelancerProfileService, UserRepository userRepository ) {
        this.freelancerProfileService = freelancerProfileService;
        this.userRepository = userRepository;
    }

    @GetMapping("/get-all-freelancers-profiles")
    public List<FreelancerProfile> getAllFreelancerProfiles() {
        return freelancerProfileService.getAllFreelancerProfiles();
    }

    @PostMapping("/create-freelancer-profile")
    public FreelancerProfile createFreelancerProfile(@RequestBody FreelancerProfileDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FreelancerProfile profile = new FreelancerProfile();
        profile.setUser(user);
        profile.setBio(dto.getBio());
        profile.setSkills(dto.getSkills());

        return freelancerProfileService.createFreelancerProfile(profile);
    }
}
