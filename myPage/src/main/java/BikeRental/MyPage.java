package BikeRental;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long userId;
        private Long voucherId;
        private Long rentalId;
        private Long bikeId;
        private String userName;
        private String bikeName;
        private Long voucherCnt;


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
        public Long getRentalId() {
            return rentalId;
        }

        public void setRentalId(Long rentalId) {
            this.rentalId = rentalId;
        }
        public Long getBikeId() {
            return bikeId;
        }

        public void setBikeId(Long bikeId) {
            this.bikeId = bikeId;
        }
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getBikeName() {
            return bikeName;
        }

        public void setBikeName(String bikeName) {
            this.bikeName = bikeName;
        }
        public Long getVoucherCnt() {
            return voucherCnt;
        }

        public void setVoucherCnt(Long voucherCnt) {
            this.voucherCnt = voucherCnt;
        }

}
