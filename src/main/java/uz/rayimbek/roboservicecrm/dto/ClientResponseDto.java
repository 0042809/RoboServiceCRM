package uz.rayimbek.roboservicecrm.dto;

import lombok.Builder;
import lombok.Data;
import uz.rayimbek.roboservicecrm.enums.Role;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ClientResponseDto {
    private Long id;
    private String phoneNumber;
    private LocalDate birthDate;
    private String passportSerial;
    private Integer passportNumber;
    private String fullName;
    private Long companyId;
    private Role role;
    private Long imageId;
    private List<Long> apartmentIds;
}
