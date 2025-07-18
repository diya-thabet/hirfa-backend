package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class JobRequestDTO {
    private Long id;
    private Long userId;
    private Long serviceId;
    private String description;
    private String status;
}