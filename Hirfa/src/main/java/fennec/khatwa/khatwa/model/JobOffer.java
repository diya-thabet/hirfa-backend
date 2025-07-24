package fennec.khatwa.khatwa.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private JobRequest jobRequest;

    @ManyToOne
    private User freelancer;
    private double price; // Initially 0, modifiable later
}