package app.db;


import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nicolas on 16.03.17.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    protected User(){}

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Follower[id=%d, name='%s']", id, name);
    }

}
