package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class JobOfferDTO {
    private Long id;
    private Long jobRequestId;
    private Long freelancerId;
    private double price;
}