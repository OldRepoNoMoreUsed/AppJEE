//package app.db;
//
//import javax.persistence.*;
//
///**
// * Created by Steve Nadalin on 23.03.2017.
// */
//@Entity
//@Table(name = "post")
//public class Post {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private String title;
//    private String content;
//    private Long projectID;
//
//    protected Post(){}
//
//    public Post(String title, String content, Long projectID){
//        this.title = title;
//        this.content = content;
//        this.projectID = projectID;
//    }
//
//    @Override
//    public String toString(){
//        return String.format("Post[id=%d, title='%s', content='%s', projectID='%s', userReceiverID='%s']", id, title, content, projectID);
//    }
//}
