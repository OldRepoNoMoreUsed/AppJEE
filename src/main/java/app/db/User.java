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
    private String userName;
    @NotNull
    private String email;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() { return userName; }
    public void setUserName(String name) {
        this.userName = name;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public User(String email, String name){
        this.email = email;
        this.userName = name;
    }

}
