package ATMMachine.DTO;

public class GetATMAmountRequestDTO {
    private String atmId;

    public GetATMAmountRequestDTO(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }
}
