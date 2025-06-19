package uz.rayimbek.roboservicecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rayimbek.roboservicecrm.entity.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
