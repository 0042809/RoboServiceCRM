package uz.rayimbek.roboservicecrm.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.rayimbek.roboservicecrm.enums.ApartmentStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apartmentName;
    private Double price;
    private Integer roomCount;
    private Double sqrM;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @Enumerated(EnumType.STRING)
    private ApartmentStatus status;
}
