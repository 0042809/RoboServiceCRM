package uz.rayimbek.roboservicecrm.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlockResponseDto {
    private Long id;
    private String blockName;
    private Integer totalApartments;
    private Integer totalFloors;
    private Long companyId;
}
