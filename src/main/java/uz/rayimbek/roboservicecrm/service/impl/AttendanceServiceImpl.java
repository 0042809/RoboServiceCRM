package uz.rayimbek.roboservicecrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.AttendanceRequestDto;
import uz.rayimbek.roboservicecrm.dto.AttendanceResponseDto;
import uz.rayimbek.roboservicecrm.entity.Attendance;
import uz.rayimbek.roboservicecrm.entity.User;
import uz.rayimbek.roboservicecrm.enums.AttendanceStatus;
import uz.rayimbek.roboservicecrm.repository.AttendanceRepository;
import uz.rayimbek.roboservicecrm.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public void generateTodayAbsences() {
        LocalDate today = LocalDate.now();
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            boolean exists = attendanceRepository.findByUserIdAndDate(user.getId(), today).isPresent();
            if (!exists) {
                Attendance attendance = Attendance.builder()
                        .user(user)
                        .date(today)
                        .status(AttendanceStatus.ABSENT)
                        .build();
                attendanceRepository.save(attendance);
            }
        }
    }

    public AttendanceResponseDto updateStatus(AttendanceRequestDto dto) {
        LocalDate today = LocalDate.now();
        Attendance attendance = attendanceRepository.findByUserIdAndDate(dto.getUserId(), today)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        attendance.setStatus(dto.getStatus());
        attendance = attendanceRepository.save(attendance);

        return AttendanceResponseDto.builder()
                .id(attendance.getId())
                .userId(attendance.getUser().getId())
                .userName(attendance.getUser().getUserName())
                .date(attendance.getDate())
                .status(attendance.getStatus())
                .build();
    }

    public List<AttendanceResponseDto> getAllToday() {
        return attendanceRepository.findAllByDate(LocalDate.now()).stream()
                .map(a -> AttendanceResponseDto.builder()
                        .id(a.getId())
                        .userId(a.getUser().getId())
                        .userName(a.getUser().getUserName())
                        .date(a.getDate())
                        .status(a.getStatus())
                        .build())
                .collect(Collectors.toList());
    }
}