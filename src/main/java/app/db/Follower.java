//package app.db;
//
//import javax.persistence.*;
//
///**
// * Created by Steve Nadalin on 23.03.2017.
// */
//@Entity
//@Table(name = "followers")
//public class Follower {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private Long userFollowedID;
//    private Long userFollowerID;
//
//    protected Follower(){}
//
//    public Follower(Long followedID, Long followerID){
//        this.userFollowedID = followedID;
//        this.userFollowerID = followerID;
//    }
//
//    @Override
//    public String toString(){
//        return String.format("Follower[id=%d, '%s' followed by '%s']", id, userFollowedID, userFollowerID);
//    }
//
//}
