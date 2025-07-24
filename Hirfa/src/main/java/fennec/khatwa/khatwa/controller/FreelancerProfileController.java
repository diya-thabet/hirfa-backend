package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.model.FreelancerProfile;
import fennec.khatwa.khatwa.service.FreelancerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/freelancer-profiles")
public class FreelancerProfileController {

    @Autowired
    private FreelancerProfileService freelancerProfileService;

    @GetMapping
    public List<FreelancerProfile> getAllFreelancerProfiles() {
        return freelancerProfileService.getAllFreelancerProfiles();
    }

    @PostMapping
    public FreelancerProfile createFreelancerProfile(@RequestBody FreelancerProfile profile) {
        return freelancerProfileService.createFreelancerProfile(profile);
    }
}