package BikeRental;

import BikeRental.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUserRegistered_then_CREATE_1 (@Payload UserRegistered userRegistered) {
        try {
            if (userRegistered.isMe()) {
                // view 객체 생성
                MyPage myPage = new MyPage();
                // view 객체에 이벤트의 Value 를 set 함
                myPage.setUserId(userRegistered.getId());
                myPage.setUserName(userRegistered.getUserName());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenUserUpdated_then_UPDATE_1(@Payload UserUpdated userUpdated) {
        try {
            if (userUpdated.isMe()) {
                // view 객체 조회
                Optional<MyPage> myPageOptional = myPageRepository.findByUserId(userUpdated.getId());
                if( myPageOptional.isPresent()) {
                    MyPage myPage = myPageOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setUserName(userUpdated.getUserName());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVoucherBought_then_UPDATE_2(@Payload VoucherBought voucherBought) {
        try {
            if (voucherBought.isMe()) {
                // view 객체 조회
                Optional<MyPage> myPageOptional = myPageRepository.findByUserId(voucherBought.getUserId());
                if( myPageOptional.isPresent()) {
                    MyPage myPage = myPageOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setVoucherId(voucherBought.getId());
                    myPage.setVoucherCnt(voucherBought.getVoucherCnt());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVoucherMinus_then_UPDATE_3(@Payload VoucherMinus voucherMinus) {
        try {
            if (voucherMinus.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByVoucherId(voucherMinus.getId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setVoucherCnt(voucherMinus.getVoucherCnt());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVoucherPlus_then_UPDATE_4(@Payload VoucherPlus voucherPlus) {
        try {
            if (voucherPlus.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByVoucherId(voucherPlus.getId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setVoucherCnt(voucherPlus.getVoucherCnt());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_UPDATE_5(@Payload Rented rented) {
        try {
            if (rented.isMe()) {
                // view 객체 조회
                Optional<MyPage> myPageOptional = myPageRepository.findByUserId(rented.getUserId());
                if( myPageOptional.isPresent()) {
                    MyPage myPage = myPageOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setRentalId(rented.getId());
                    myPage.setBikeId(rented.getBikeId());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeRented_then_UPDATE_6(@Payload BikeRented bikeRented) {
        try {
            if (bikeRented.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByBikeId(bikeRented.getId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setBikeName(bikeRented.getBikeName());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRentalCancelled_then_UPDATE_7(@Payload RentalCancelled rentalCancelled) {
        try {
            if (rentalCancelled.isMe()) {
                // view 객체 조회
                Optional<MyPage> myPageOptional = myPageRepository.findByUserId(rentalCancelled.getUserId());
                if( myPageOptional.isPresent()) {
                    MyPage myPage = myPageOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setRentalId(rentalCancelled.getId());
                    myPage.setBikeId(rentalCancelled.getBikeId());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBikeRentalCancelled_then_UPDATE_8(@Payload BikeRentalCancelled bikeRentalCancelled) {
        try {
            if (bikeRentalCancelled.isMe()) {
                // view 객체 조회
                List<MyPage> myPageList = myPageRepository.findByBikeId(bikeRentalCancelled.getId());
                for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setBikeName(bikeRentalCancelled.getBikeName());
                    // view 레파지 토리에 save
                    myPageRepository.save(myPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUserDeleted_then_DELETE_1(@Payload UserDeleted userDeleted) {
        try {
            if (userDeleted.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                myPageRepository.deleteById(userDeleted.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}