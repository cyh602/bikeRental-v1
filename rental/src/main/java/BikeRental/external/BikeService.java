
package BikeRental.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="bike", url="http://bike:8080")
public interface BikeService {

    @RequestMapping(method= RequestMethod.GET, path="/bikes")
    public void rent(@RequestBody Bike bike);

}