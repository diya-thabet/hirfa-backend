package fennec.khatwa.khatwa.service;


import fennec.khatwa.khatwa.dto.ReviewDTO;
import fennec.khatwa.khatwa.model.JobRequest;
import fennec.khatwa.khatwa.model.Review;
import fennec.khatwa.khatwa.model.ServiceOffer;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.repository.JobRequestRepository;
import fennec.khatwa.khatwa.repository.ReviewRepository;
import fennec.khatwa.khatwa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final JobRequestRepository jobRequestRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, JobRequestRepository jobRequestRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.jobRequestRepository = jobRequestRepository;
    }

    public Review createReview(ReviewDTO review) {
        Optional<User> userOptional = userRepository.findById(review.getUserId());
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + review.getUserId() + " not found.");
        }
        User user = userOptional.get();


        Optional<JobRequest> jobRequestOptional = jobRequestRepository.findById(review.getJobRequestId());
        if (jobRequestOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "job request with ID " + review.getJobRequestId() + " not found.");
        }
        JobRequest jobRequest = jobRequestOptional.get();

        // setting the review object after transforming it from DTO to an object
        Review reviewEntity = new Review();
        reviewEntity.setComment(review.getComment());
        reviewEntity.setRating(review.getRating());
        reviewEntity.setUser(user);
        reviewEntity.setJobRequest(jobRequest);

        return reviewRepository.save(reviewEntity);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}