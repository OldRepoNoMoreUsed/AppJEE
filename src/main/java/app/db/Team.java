package app.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private List<Long> members;

    protected Team(){}

    public Team(String name, List<Long> members){
        this.name = name;
        this.members = members;
    }

    @Override
    public String toString(){
        return String.format("Team[id=%d, name='%s', members='%s']", id, name, members);
    }
}
