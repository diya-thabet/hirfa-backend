package fennec.khatwa.khatwa.controller;



import fennec.khatwa.khatwa.model.Review;
import fennec.khatwa.khatwa.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/get-all-reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/create-review")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }
}