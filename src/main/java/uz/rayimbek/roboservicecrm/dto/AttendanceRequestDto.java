package uz.rayimbek.roboservicecrm.dto;

import lombok.Data;
import uz.rayimbek.roboservicecrm.enums.AttendanceStatus;

@Data
public class AttendanceRequestDto {
    private Long userId;
    private AttendanceStatus status;
}
