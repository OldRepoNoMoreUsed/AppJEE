package app.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mega- on 23.04.2017.
 */
public class CreatePostForm {
    @NotNull
    @Size(min=6, max=2000, message = "Content size should be in the range 6...2000")
    private String body;

    @NotNull
    @Size(min=2, max=100, message = "Title size should be in the range 2...100")
    private String title;

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
