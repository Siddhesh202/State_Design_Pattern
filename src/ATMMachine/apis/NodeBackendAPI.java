package ATMMachine.apis;

import ATMMachine.DTO.CreateTransactionDTO;
import ATMMachine.DTO.GetATMAmountRequestDTO;
import ATMMachine.DTO.UpdateATMStateRequestDTO;

public class NodeBackendAPI implements BackendAPI {

    // Should be only responsible for interacting with the backend and getting back the required data
    // Should not contain any business logic

    @Override
    public int createTransaction(CreateTransactionDTO createTransactionDTO) {
        // Create a transaction
        String atmID = createTransactionDTO.getAtmID();
        if(atmID == null || atmID.isEmpty()) {
            throw new IllegalArgumentException("ATM ID cannot be null or empty");
        }

        // Call the backend API to create a transaction
        int txnId = (int) (Math.random() * 1000);

        return txnId;
    }

    @Override
    public boolean updateState(UpdateATMStateRequestDTO updateATMStateDTO) {

        // Assume that there is the implementation that calls the backend to update the state of the ATM

        return true; // mimiced response
    }

    @Override
    public int getATMAmount(GetATMAmountRequestDTO getATMAmountRequestDTO) {
        return 10000;
    }
}
