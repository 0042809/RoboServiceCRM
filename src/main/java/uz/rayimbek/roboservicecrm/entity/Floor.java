package uz.rayimbek.roboservicecrm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String floorName;
    private Integer totalAppartmentsOfFloor;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
}
