package uz.rayimbek.roboservicecrm.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ContractResponseDto {
    private Long id;
    private String contractId;
    private Long apartmentId;
    private Long clientId;
    private Long userId;
    private Long companyId;
    private LocalDateTime contractDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
