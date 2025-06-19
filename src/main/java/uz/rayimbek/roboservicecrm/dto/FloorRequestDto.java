package uz.rayimbek.roboservicecrm.dto;

import lombok.Data;

@Data
public class FloorRequestDto {
    private String floorName;
    private Integer totalApartmentsOfFloor;
    private Long blockId;
}
