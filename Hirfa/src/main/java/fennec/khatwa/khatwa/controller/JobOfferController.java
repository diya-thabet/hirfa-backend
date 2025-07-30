package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.dto.JobOfferDTO;
import fennec.khatwa.khatwa.model.JobOffer;
import fennec.khatwa.khatwa.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/freelancer/job-offers")
public class JobOfferController {

    private final JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping("/get-all-job-offers")
    public List<JobOffer> getAllJobOffers() {
        return jobOfferService.getAllJobOffers();
    }

    @PostMapping("/create-job-offer")
    public JobOffer createJobOffer(@RequestBody JobOfferDTO jobOfferDTO) {
        return jobOfferService.createJobOffer(jobOfferDTO);
    }
}