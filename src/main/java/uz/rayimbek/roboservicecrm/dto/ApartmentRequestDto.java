package uz.rayimbek.roboservicecrm.dto;

import lombok.Data;
import uz.rayimbek.roboservicecrm.enums.ApartmentStatus;

@Data
public class ApartmentRequestDto {
    private String apartmentName;
    private Double price;
    private Integer roomCount;
    private Double sqrM;
    private Long floorId;
    private Long blockId;
    private ApartmentStatus status;
}
