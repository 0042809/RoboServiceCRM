package uz.rayimbek.roboservicecrm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponseDto {
    private Long id;
    private String name;
    private String address;
    private String description;
    private boolean active;
}
