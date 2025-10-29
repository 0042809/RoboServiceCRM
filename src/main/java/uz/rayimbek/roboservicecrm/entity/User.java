package uz.rayimbek.roboservicecrm.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.rayimbek.roboservicecrm.enums.Role;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String phoneNumber;

    private LocalDate birthDate;

    private String passportSerial;
    private Integer passportNumber;

    private String fullName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    private String password;
}
