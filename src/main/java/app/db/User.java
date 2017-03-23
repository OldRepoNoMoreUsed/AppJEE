package app.db;



import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public User(String email, String name){
        this.email = email;
        this.name = name;
=======
    @Override
    public String toString(){
        return String.format("Follower[id=%d, name='%s']", id, name);
>>>>>>> bbea560722e8bcd25081c683f8068f964ac603b9
    }

}
