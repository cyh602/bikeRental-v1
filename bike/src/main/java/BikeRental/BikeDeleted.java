package BikeRental;

public class BikeDeleted extends AbstractEvent {

    private Long id;

    public BikeDeleted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
