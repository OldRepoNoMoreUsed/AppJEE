package app.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long userFollowedID;
    @NotNull
    private Long userFollowerID;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getuserFollowedID() { return userFollowedID; }
    public void setUserFollowedID(Long userFollowedID) {
        this.userFollowedID = userFollowedID;
    }
    public Long getUserFollowerID() { return userFollowerID; }
    public void setUserFollowerID(Long userFollowerID) {
        this.userFollowerID = userFollowerID;
    }

    public Follower(Long followedID, Long followerID){
        this.userFollowedID = followedID;
        this.userFollowerID = followerID;
    }

}
