package uz.rayimbek.roboservicecrm.dto;

import lombok.Builder;
import lombok.Data;
import uz.rayimbek.roboservicecrm.enums.ApartmentStatus;

@Data
@Builder
public class ApartmentResponseDto {
    private Long id;
    private String apartmentName;
    private Double price;
    private Integer roomCount;
    private Double sqrM;
    private Long floorId;
    private Long blockId;
    private ApartmentStatus status;
}
