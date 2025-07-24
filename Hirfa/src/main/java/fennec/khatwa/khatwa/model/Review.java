package fennec.khatwa.khatwa.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private JobRequest jobRequest;
    private int rating;
    private String comment;
}