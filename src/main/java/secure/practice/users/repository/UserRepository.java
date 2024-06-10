package secure.practice.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secure.practice.domain.entity.Account;

public interface UserRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
