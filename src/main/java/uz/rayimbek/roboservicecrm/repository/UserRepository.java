package uz.rayimbek.roboservicecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rayimbek.roboservicecrm.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
