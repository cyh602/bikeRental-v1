package BikeRental;

public class BikeRegistered extends AbstractEvent {

    private Long id;
    private String status;
    private String bikeName;

    public BikeRegistered(){
        super();
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
