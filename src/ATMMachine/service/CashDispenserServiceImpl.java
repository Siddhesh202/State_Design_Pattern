package ATMMachine.service;

import ATMMachine.DTO.GetATMAmountRequestDTO;
import ATMMachine.apis.BackendAPI;
import ATMMachine.models.ATM;

public class CashDispenserServiceImpl implements CashDispenserService{
    private BackendAPI backendAPI;

    public CashDispenserServiceImpl(BackendAPI backendAPI) {
        this.backendAPI = backendAPI;
    }

    @Override
    public void dispenseCash(ATM atm, double amount) {
        int atmAmount = this.backendAPI.getATMAmount(new GetATMAmountRequestDTO(atm.getAtmID()));

        if(atmAmount < amount) {
            throw new RuntimeException("ATM does not have enough cash to dispense");
        }

        System.out.println("Dispensing cash: " + amount);
    }
}
