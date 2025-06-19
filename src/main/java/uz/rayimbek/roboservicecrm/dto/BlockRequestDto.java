package uz.rayimbek.roboservicecrm.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlockRequestDto {
    private String blockName;
    private Integer totalApartments;
    private Integer totalFloors;
    private Long companyId;
}