package app.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setName(String title) {
        this.title = title;
    }
    public String getDescription() { return description; }
    public void setEmail(String email) {
        this.description = description;
    }

    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }
}
