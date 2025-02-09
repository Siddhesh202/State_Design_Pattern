package ATMMachine.DTO;

public class CreateTransactionDTO {

    private final String atmID;

    public CreateTransactionDTO(String atmID) {
        this.atmID = atmID;
    }

    public String getAtmID() {
        return atmID;
    }
}
