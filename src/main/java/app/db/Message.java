package app.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String message;
    @NotNull
    private Long userSenderID;
    @NotNull
    private Long userReceiverID;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() { return message; }
    public void setMessage(String message) {
        this.message = message;
    }
    public Long getUserSenderID() {
        return userSenderID;
    }
    public void setUserSenderID(Long userSenderID) {
        this.userSenderID = userSenderID;
    }
    public Long getUserReceiverID() { return userReceiverID; }
    public void setUserReceiverID(Long userReceiverID) {
        this.userReceiverID = userReceiverID;
    }

    public Message(String title, String message, Long userSenderID, Long userReceiverID){
        this.title = title;
        this.message = message;
        this.userSenderID = userSenderID;
        this.userReceiverID = userReceiverID;
    }

}
