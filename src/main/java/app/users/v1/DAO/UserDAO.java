package app.users.v1.DAO;

import app.users.v1.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
