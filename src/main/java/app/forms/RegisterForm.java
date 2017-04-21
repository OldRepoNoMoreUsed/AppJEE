package app.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {

    @NotNull
    @Size(min=2, max=32, message = "Username size should be in the range 2...32")
    private String username;

    @NotNull
    @Size(min=6, max=32, message = "Password size should be in the range 6...32")
    private String password;

    @NotNull
    @Size(min=3, max=64, message="Email size should be in the range 3...64")
    private String email;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
}
