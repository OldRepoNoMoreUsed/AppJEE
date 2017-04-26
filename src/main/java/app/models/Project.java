package app.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mega- on 22.04.2017.
 */
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User admin;

    @Column(nullable = false)
    private Date date = new Date();

    @ManyToMany
    private List<User> availableUser;

    public Project() {super();}

    public List<User> getAvailableUser() {
        return availableUser;
    }

    public void setAvailableUser(List<User> availableUser) {
        this.availableUser = availableUser;
    }

    public Project(String title, String description, User admin) {
        this.title = title;
        this.description = description;
        this.admin = admin;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean hasMembers(User user){
        for(User u: getAvailableUser()){
            if(u.getId() == user.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + description + '\'' +
                ", author=" + admin +
                ", date=" + date +
                '}';
    }
}
