package BikeRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Rental_table")
public class Rental {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long voucherId;
    private Long bikeId;

    @PostPersist
    public void onPostPersist(){
        CheckStatus checkStatus = new CheckStatus();
        BeanUtils.copyProperties(this, checkStatus);
        checkStatus.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        BikeRental.external.Voucher voucher = new BikeRental.external.Voucher();
        // mappings goes here
        RentalApplication.applicationContext.getBean(BikeRental.external.VoucherService.class)
            .getStatus(voucher);


    }

    @PostUpdate
    public void onPostUpdate(){
        Rented rented = new Rented();
        BeanUtils.copyProperties(this, rented);
        rented.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        BikeRental.external.Bike bike = new BikeRental.external.Bike();
        // mappings goes here
        RentalApplication.applicationContext.getBean(BikeRental.external.BikeService.class)
            .rent(bike);


    }

    @PreRemove
    public void onPreRemove(){
        RentalCancelled rentalCancelled = new RentalCancelled();
        BeanUtils.copyProperties(this, rentalCancelled);
        rentalCancelled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }
    public Long getBikeId() {
        return bikeId;
    }

    public void setBikeId(Long bikeId) {
        this.bikeId = bikeId;
    }




}
