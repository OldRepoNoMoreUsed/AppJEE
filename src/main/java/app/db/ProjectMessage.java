//package app.db;
//
//import javax.persistence.*;
//
///**
// * Created by Steve Nadalin on 23.03.2017.
// */
//@Entity
//@Table(name = "projectMessages")
//public class ProjectMessage {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private String title;
//    private String message;
//    private Long teamID;
//    private Long userID;
//
//    protected ProjectMessage(){}
//
//    public ProjectMessage(String title, String message, Long teamID, Long userID){
//        this.title = title;
//        this.message = message;
//        this.teamID = teamID;
//        this.userID = userID;
//    }
//
//    @Override
//    public String toString(){
//        return String.format("Message[id=%d, title='%s', message='%s', teamID='%s', userID='%s']", id, title, message, teamID, userID);
//    }
//}
