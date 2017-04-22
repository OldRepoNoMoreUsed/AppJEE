package app.services;

import app.models.Post;
import app.models.Project;

import java.util.List;

/**
 * Created by mega- on 22.04.2017.
 */
public interface ProjectService {
    List<Project> findAll();
    List<Project> findLatest5();
    Project findById(Long id);
    Project create(Project project);
    Project edit(Project project);
    void deleteById(Long id);
}
