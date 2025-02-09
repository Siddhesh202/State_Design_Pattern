package ATMMachine.models;

import ATMMachine.DTO.UpdateATMStateRequestDTO;
import ATMMachine.apis.BackendAPI;
import ATMMachine.apis.NodeBackendAPI;
import ATMMachine.state.ReadyForTransactionState;
import ATMMachine.state.State;

public class ATM {
    private final String atmID;
    private State state;
    private final BackendAPI backendAPI;
    public ATM(String atmID) {
        this.atmID = atmID;
        this.backendAPI = new NodeBackendAPI();
        this.state = new ReadyForTransactionState(this, backendAPI);
    }

    public String getAtmID() {
        return atmID;
    }

    public void changeState(State newState) {
        this.state = newState;
        backendAPI.updateState(new UpdateATMStateRequestDTO(this.atmID, newState.getState()));
    }
}
