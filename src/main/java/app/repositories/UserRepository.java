package app.repositories;

import app.models.Project;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);

    @Query("SELECT p FROM User p WHERE p.username LIKE %:name% ")
    List<User> findByName(@Param("name") String name);
}
