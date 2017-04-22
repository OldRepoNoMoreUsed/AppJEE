/*package app.services;

import app.models.Project;
import app.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class ProjectServiceStubImpl implements ProjectService{
    private List<Project> projects = new ArrayList<Project>(){{
        add(new Project(1L, "First Post", "<p>Line#1.</p><p>Line#2</p>", null));
        add(new Project(2L, "Second Post", "Second post content: <ul><li>line 1</li><li>line 2 </li></p>",
                new User(10L, "Fixfox", "sommer.nicolas92@gmail.com")));
        add(new Project(3L,"Post #3", "<p>The post number 3</p>", new User(11L, "merry", "poil@mail.com")));
        add(new Project(4L, "Forth post", "<p>Not interesting post</p>", null));
        add(new Project(5L, "Post Number 5", "<p>Just posting</p>", null));
        add(new Project(6L, "Sixth Post", "<p>Another interesting post</p>", null));
    }};

    @Override
    public List<Project> findAll() {
        return this.projects;
    }

    @Override
    public List<Project> findLatest5() {
        return this.projects.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Project findById(Long id) {
        return this.projects.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Project create(Project project) {
        project.setId(this.projects.stream().mapToLong(
                p -> p.getId()).max().getAsLong() + 1);
        this.projects.add(project);
        return project;
    }

    @Override
    public Project edit(Project project) {
        for (int i = 0; i < this.projects.size(); i++) {
            if (Objects.equals(this.projects.get(i).getId(), project.getId())) {
                this.projects.set(i, project);
                return project;
            }
        }
        throw new RuntimeException("Post not found: " + project.getId());
    }

    @Override
    public void deleteById(Long id){
        for(int i = 0; i < this.projects.size(); i++){
            if(Objects.equals(this.projects.get(i).getId(), id)){
                this.projects.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);
    }
}
*/