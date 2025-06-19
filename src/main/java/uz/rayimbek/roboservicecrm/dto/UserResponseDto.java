package uz.rayimbek.roboservicecrm.dto;

import lombok.*;
import uz.rayimbek.roboservicecrm.enums.Role;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String userName;
    private String phoneNumber;
    private LocalDate birthDate;
    private String passportSerial;
    private Integer passportNumber;
    private String fullName;
    private Long companyId;
    private Role role;
    private Long imageId;
}
