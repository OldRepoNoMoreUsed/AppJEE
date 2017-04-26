package app.services;

import app.models.Project;
import app.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mega- on 22.04.2017.
 */
@Service
@Primary
public class ProjectServiceJpaImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public List<Project> findAll() {
        return this.projectRepo.findAll();
    }

    @Override
    public List<Project> findByName(String name){
        return this.projectRepo.findByName(name);
        //return this.projectRepo.findAll();
    }

    @Override
    public List<Project> findLatest5() {
        return this.projectRepo.findLatest5Projects(new PageRequest(0, 5));
    }

    @Override
    public Project findById(Long id) {
        return this.projectRepo.findOne(id);
    }

    @Override
    public Project create(Project project) {
        return this.projectRepo.save(project);
    }

    @Override
    public Project edit(Project project) {
        return this.projectRepo.save(project);
    }

    @Override
    public void deleteById(Long id) {
        this.projectRepo.delete(id);
    }

    @Override
    public void save(Project project){
        this.projectRepo.save(project);
    }
}
