package BikeRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="User_table")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userName;

    @PostPersist
    public void onPostPersist(){
        UserRegistered userRegistered = new UserRegistered();
        BeanUtils.copyProperties(this, userRegistered);
        userRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        UserUpdated userUpdated = new UserUpdated();
        BeanUtils.copyProperties(this, userUpdated);
        userUpdated.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        UserDeleted userDeleted = new UserDeleted();
        BeanUtils.copyProperties(this, userDeleted);
        userDeleted.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




}
