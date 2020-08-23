package BikeRental;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyPageRepository extends CrudRepository<MyPage, Long> {

    List<MyPage> findByVoucherId(Long voucherId);
    List<MyPage> findByVoucherId(Long voucherId);
    List<MyPage> findByBikeId(Long bikeId);
    List<MyPage> findByBikeId(Long bikeId);

}