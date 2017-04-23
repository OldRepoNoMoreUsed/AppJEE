package app.services;

import app.models.Post;
import app.models.Project;
import javafx.geometry.Pos;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    List<Post> findByProject(Project project);
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
