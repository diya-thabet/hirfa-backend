package fennec.khatwa.khatwa.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class JobRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private ServiceOffer service;
    private String description;
    private String status; // "OPEN", "IN_PROGRESS", "COMPLETED"
}