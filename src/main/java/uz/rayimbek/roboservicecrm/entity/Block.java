package uz.rayimbek.roboservicecrm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blockName;
    private Integer totalApartments;
    private Integer totalFloors;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    private boolean active = true;
}
