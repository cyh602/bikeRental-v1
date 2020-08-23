package BikeRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Bike_table")
public class Bike {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status;
    private String bikeName;

    @PostPersist
    public void onPostPersist(){
        BikeRegistered bikeRegistered = new BikeRegistered();
        BeanUtils.copyProperties(this, bikeRegistered);
        bikeRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        BikeRented bikeRented = new BikeRented();
        BeanUtils.copyProperties(this, bikeRented);
        bikeRented.publishAfterCommit();


        BikeRentalCancelled bikeRentalCancelled = new BikeRentalCancelled();
        BeanUtils.copyProperties(this, bikeRentalCancelled);
        bikeRentalCancelled.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        BikeDeleted bikeDeleted = new BikeDeleted();
        BeanUtils.copyProperties(this, bikeDeleted);
        bikeDeleted.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }




}
