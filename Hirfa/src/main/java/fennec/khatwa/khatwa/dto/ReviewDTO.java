package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class ReviewDTO {
    private Long jobRequestId;
    private int rating;
    private String comment;
    private long userId;


    public Long getJobRequestId() {
        return jobRequestId;
    }

    public void setJobRequestId(Long jobRequestId) {
        this.jobRequestId = jobRequestId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}