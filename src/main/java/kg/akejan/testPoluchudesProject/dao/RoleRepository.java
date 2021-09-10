package kg.akejan.testPoluchudesProject.dao;

import kg.akejan.testPoluchudesProject.models.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    @Query(value = "select * from roles r where r.name = ?1", nativeQuery = true)
    Roles findByName(String name);
}
