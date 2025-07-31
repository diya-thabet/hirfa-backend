package fennec.khatwa.khatwa.controller;



import fennec.khatwa.khatwa.dto.ReviewDTO;
import fennec.khatwa.khatwa.model.Review;
import fennec.khatwa.khatwa.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/get-all-reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/create-review")
    public Review createReview(@RequestBody ReviewDTO review) {
        return reviewService.createReview(review);
    }
}