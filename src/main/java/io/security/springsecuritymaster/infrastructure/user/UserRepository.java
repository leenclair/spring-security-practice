package io.security.springsecuritymaster.infrastructure.user;

import io.security.springsecuritymaster.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserToken(String userToken);
}
