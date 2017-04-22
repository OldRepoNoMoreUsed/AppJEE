package app.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by mega- on 22.04.2017.
 */
public class CreateForm {

    @NotNull
    @Size(min=6, max=2000, message = "Description size should be in the range 6...2000")
    private String description;

    @NotNull
    @Size(min=2, max=100, message = "Title size should be in the range 2...100")
    private String title;

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
