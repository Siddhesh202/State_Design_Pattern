package ATMMachine.apis;

import ATMMachine.DTO.CreateTransactionDTO;
import ATMMachine.DTO.GetATMAmountRequestDTO;
import ATMMachine.DTO.UpdateATMStateRequestDTO;

public interface BackendAPI {

    public int createTransaction(CreateTransactionDTO createTransactionDTO);

    public boolean updateState(UpdateATMStateRequestDTO updateATMStateDTO);

    int getATMAmount(GetATMAmountRequestDTO getATMAmountRequestDTO);
}
