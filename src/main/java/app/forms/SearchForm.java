package app.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mega- on 22.04.2017.
 */
public class SearchForm {
    @Size(min=2, max=32, message = "Username size should be in the range 2...32")
    private String username;

    @NotNull
    @Size(min=6, max=32, message = "Password size should be in the range 6...32")
    private String password;

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
}
