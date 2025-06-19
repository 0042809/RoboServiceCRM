package uz.rayimbek.roboservicecrm.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.rayimbek.roboservicecrm.enums.AttendanceStatus;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;
}
