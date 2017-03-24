//package app.db;
//
//import javax.persistence.*;
//
///**
// * Created by Steve Nadalin on 23.03.2017.
// */
//@Entity
//@Table(name = "messages")
//public class Message {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private String title;
//    private String message;
//    private Long userSenderID;
//    private Long userReceiverID;
//
//    protected Message(){}
//
//    public Message(String title, String message, Long userSenderID, Long userReceiverID){
//        this.title = title;
//        this.message = message;
//        this.userSenderID = userSenderID;
//        this.userReceiverID = userReceiverID;
//    }
//
//    @Override
//    public String toString(){
//        return String.format("Message[id=%d, title='%s', message='%s', userSenderID='%s', userReceiverID='%s']", id, title, message, userSenderID, userReceiverID);
//    }
//
//}
