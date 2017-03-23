package app.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    protected Project(){}

    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Message[id=%d, title='%s', description='%s']", id, title, description);
    }
}
