package BikeRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Voucher_table")
public class Voucher {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long voucherCnt;

    @PostPersist
    public void onPostPersist(){
        VoucherBought voucherBought = new VoucherBought();
        BeanUtils.copyProperties(this, voucherBought);
        voucherBought.publishAfterCommit();


        GetStatus getStatus = new GetStatus();
        BeanUtils.copyProperties(this, getStatus);
        getStatus.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        VoucherMinus voucherMinus = new VoucherMinus();
        BeanUtils.copyProperties(this, voucherMinus);
        voucherMinus.publishAfterCommit();


        VoucherPlus voucherPlus = new VoucherPlus();
        BeanUtils.copyProperties(this, voucherPlus);
        voucherPlus.publishAfterCommit();


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
    public Long getVoucherCnt() {
        return voucherCnt;
    }

    public void setVoucherCnt(Long voucherCnt) {
        this.voucherCnt = voucherCnt;
    }




}
