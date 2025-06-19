package uz.rayimbek.roboservicecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rayimbek.roboservicecrm.entity.Attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAllByDate(LocalDate date);
    Optional<Attendance> findByUserIdAndDate(Long userId, LocalDate date);
}
