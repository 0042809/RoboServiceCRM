package uz.rayimbek.roboservicecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rayimbek.roboservicecrm.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
