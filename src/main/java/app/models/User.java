package app.models;

import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32, unique = true)
    private String username;

    @Column(length = 60)
    private String passwordHash;

    @Column(length = 100)
    private String email;

    @ManyToMany
    private List<Skill> skills;

    public List<Skill> getSkills(){
        return this.skills;
    }

    public void setSkills(List<Skill> skills){
        this.skills = skills;
    }

    public boolean hasSkill(Skill skill){
        for(Skill containedSkill: getSkills()){
            if(containedSkill.getId() == skill.getId()){
                return true;
            }
        }
        return false;
    }

    public User() {}
    public User(Long id, String username, String email){
        this.id = id;
        this.username = username;
        this.passwordHash = getPasswordHash();
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHah='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
