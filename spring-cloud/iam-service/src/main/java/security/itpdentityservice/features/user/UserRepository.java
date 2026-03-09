package security.itpdentityservice.features.user;

import org.springframework.data.jpa.repository.JpaRepository;
import security.itpdentityservice.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
