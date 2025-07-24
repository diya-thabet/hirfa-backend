package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.dto.JobOfferDTO;
import fennec.khatwa.khatwa.model.JobOffer;
import fennec.khatwa.khatwa.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelancer/job-offers")
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping
    public List<JobOffer> getAllJobOffers() {
        return jobOfferService.getAllJobOffers();
    }

    @PostMapping
    public JobOffer createJobOffer(@RequestBody JobOfferDTO jobOfferDTO) {
        return jobOfferService.createJobOffer(jobOfferDTO);
    }
}