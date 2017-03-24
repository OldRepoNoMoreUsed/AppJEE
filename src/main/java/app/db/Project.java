//package app.db;
//
//import javax.persistence.*;
//
///**
// * Created by Steve Nadalin on 23.03.2017.
// */
//@Entity
//@Table(name = "project")
//public class Project {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private String title;
//    private String description;
//
//    protected Project(){}
//
//    public Project(String title, String description){
//        this.title = title;
//        this.description = description;
//    }
//
//    @Override
//    public String toString(){
//        return String.format("Message[id=%d, title='%s', description='%s']", id, title, description);
//    }
//}
