package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String role; // "USER" or "FREELANCER"
}