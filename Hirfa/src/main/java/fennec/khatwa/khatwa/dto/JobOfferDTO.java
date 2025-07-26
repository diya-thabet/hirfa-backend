package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class JobOfferDTO {
    private Long id;
    private Long jobRequestId;
    private Long freelancerId;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobRequestId() {
        return jobRequestId;
    }

    public void setJobRequestId(Long jobRequestId) {
        this.jobRequestId = jobRequestId;
    }

    public Long getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(Long freelancerId) {
        this.freelancerId = freelancerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}