package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.AttendanceRequestDto;
import uz.rayimbek.roboservicecrm.dto.AttendanceResponseDto;
import uz.rayimbek.roboservicecrm.service.impl.AttendanceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceServiceImpl attendanceService;

    @PostMapping("/generate")
    public void generateDailyAbsenceForAllUsers() {
        attendanceService.generateTodayAbsences();
    }

    @PutMapping
    public AttendanceResponseDto updateAttendance(@RequestBody AttendanceRequestDto dto) {
        return attendanceService.updateStatus(dto);
    }

    @GetMapping
    public List<AttendanceResponseDto> getTodayAttendance() {
        return attendanceService.getAllToday();
    }
}
