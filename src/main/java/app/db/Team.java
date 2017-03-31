package app.db;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * Created by Steve Nadalin on 23.03.2017.
 */
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long projectID;
    @NotNull
    private Long memberID;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProjectID() {
        return projectID;
    }
    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }
    public Long getMemberID() { return memberID; }
    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public Team(Long projectID, Long memberID) {
        this.projectID = projectID;
        this.memberID = memberID;
    }

}