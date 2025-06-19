    package uz.rayimbek.roboservicecrm.entity;

    import jakarta.persistence.*;
    import lombok.*;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Company {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String address;
        private String description;
        private boolean active;
    }
