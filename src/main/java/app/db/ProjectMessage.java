//package app.db;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
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
//    @NotNull
//    private String title;
//    @NotNull
//    private String message;
//    @NotNull
//    private Long teamID;
//    @NotNull
//    private Long userID;
//
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public Long getProjectID() {
//        return projectID;
//    }
//    public void setProjectID(Long projectID) {
//        this.projectID = projectID;
//    }
//    public Long getMemberID() { return memberID; }
//    public void setMemberID(Long memberID) {
//        this.memberID = memberID;
//    }
//
//    public ProjectMessage(String title, String message, Long teamID, Long userID){
//        this.title = title;
//        this.message = message;
//        this.teamID = teamID;
//        this.userID = userID;
//    }
//}
