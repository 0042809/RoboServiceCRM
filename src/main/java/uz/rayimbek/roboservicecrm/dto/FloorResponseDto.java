package uz.rayimbek.roboservicecrm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FloorResponseDto {
    private Long id;
    private String floorName;
    private Integer totalApartmentsOfFloor;
    private Long blockId;
}
