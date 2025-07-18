package fennec.khatwa.khatwa.dto;


import lombok.Data;

@Data
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
}