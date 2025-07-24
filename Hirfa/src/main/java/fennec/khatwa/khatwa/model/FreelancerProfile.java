package fennec.khatwa.khatwa.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class FreelancerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
    private String bio;
    private String skills;
}