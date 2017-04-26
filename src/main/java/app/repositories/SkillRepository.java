package app.repositories;

import app.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long>{
    public List<Skill> findByLabel(String label);
}
