package uz.rayimbek.roboservicecrm.dto;

import lombok.Data;

@Data
public class ContractRequestDto {
    private String contractId;
    private Long apartmentId;
    private Long clientId;
    private Long userId;
    private Long companyId;
}
