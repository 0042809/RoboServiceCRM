package uz.rayimbek.roboservicecrm.dto;

import lombok.Builder;
import lombok.Data;
import uz.rayimbek.roboservicecrm.enums.AttendanceStatus;

import java.time.LocalDate;

@Data
@Builder
public class AttendanceResponseDto {
    private Long id;
    private Long userId;
    private String userName;
    private LocalDate date;
    private AttendanceStatus status;
}
