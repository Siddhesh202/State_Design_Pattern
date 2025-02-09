package ATMMachine.service;

import ATMMachine.models.ATM;

public interface CashDispenserService {
    public void dispenseCash(ATM atm, double amount);
}
