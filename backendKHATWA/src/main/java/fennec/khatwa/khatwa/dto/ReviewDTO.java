package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private Long jobRequestId;
    private int rating;
    private String comment;
}