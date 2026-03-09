package security.itpdentityservice.features.role;

import org.springframework.data.jpa.repository.JpaRepository;
import security.itpdentityservice.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
