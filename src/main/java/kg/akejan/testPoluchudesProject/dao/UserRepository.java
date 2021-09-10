package kg.akejan.testPoluchudesProject.dao;

import kg.akejan.testPoluchudesProject.models.dto.UserDto;
import kg.akejan.testPoluchudesProject.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "select * from users u where u.login = ?1",nativeQuery = true)
    Users finByLogin(String login);
}
