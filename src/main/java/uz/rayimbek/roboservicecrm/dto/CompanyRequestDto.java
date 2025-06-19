package uz.rayimbek.roboservicecrm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyRequestDto {
    @NotBlank(message = "Company nomi bo‘sh bo‘lmasligi kerak")
    private String name;

    @NotBlank(message = "Address bo‘sh bo‘lmasligi kerak")
    private String address;

    private String description;
    private boolean active;
}
