package uz.rayimbek.roboservicecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rayimbek.roboservicecrm.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
