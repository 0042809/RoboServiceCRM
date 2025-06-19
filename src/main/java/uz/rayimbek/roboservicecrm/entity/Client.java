package uz.rayimbek.roboservicecrm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private LocalDate birthDate;
    private String passportSerial;
    private Integer passportNumber;
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    private uz.rayimbek.roboservicecrm.enums.Role role;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToMany
    @JoinTable(
            name = "client_apartments",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id")
    )
    private List<Apartment> apartments;
}
