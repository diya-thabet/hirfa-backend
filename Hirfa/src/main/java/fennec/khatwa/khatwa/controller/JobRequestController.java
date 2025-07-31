package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.dto.JobRequestDTO;
import fennec.khatwa.khatwa.model.JobRequest;
import fennec.khatwa.khatwa.service.JobRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/job-requests")
public class JobRequestController {

    private final JobRequestService jobRequestService;

    public JobRequestController(JobRequestService jobRequestService) {
        this.jobRequestService = jobRequestService;
    }

    @GetMapping("/getalljobs")
    public List<JobRequest> getAllJobRequests() {
        return jobRequestService.getAllJobRequests();
    }

    @PostMapping("/createjob")
    public JobRequest createJobRequest(@RequestBody JobRequestDTO jobRequestDTO) {
        return jobRequestService.createJobRequest(jobRequestDTO);
    }
}