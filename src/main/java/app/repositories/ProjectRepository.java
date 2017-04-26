package app.repositories;

import app.models.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mega- on 22.04.2017.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.admin ORDER BY p.date DESC")
    List<Project> findLatest5Projects(Pageable pageable);

    @Query("SELECT p FROM Project p WHERE p.title LIKE %:name% ")
    List<Project> findByName(@Param("name") String name);


}
