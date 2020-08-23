
package BikeRental.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="voucher", url="http://voucher:8080")
public interface VoucherService {

    @RequestMapping(method= RequestMethod.GET, path="/vouchers")
    public void rent(@RequestBody Voucher voucher);

}