package app.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Long projectID;
    @NotNull
    private boolean restricted;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() { return content; }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getProjectID() {
        return projectID;
    }
    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }
    public boolean getRestricted() {
        return restricted;
    }
    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public Post(String title, String content, Long projectID, boolean restricted){
        this.title = title;
        this.content = content;
        this.projectID = projectID;
        this.restricted = restricted;
    }
}
