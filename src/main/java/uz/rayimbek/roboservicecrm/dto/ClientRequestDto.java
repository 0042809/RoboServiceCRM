package uz.rayimbek.roboservicecrm.dto;

import lombok.Data;
import uz.rayimbek.roboservicecrm.enums.Role;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClientRequestDto {
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
