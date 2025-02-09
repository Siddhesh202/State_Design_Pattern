package ATMMachine.state;

import ATMMachine.apis.BackendAPI;
import ATMMachine.enums.ATMState;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;

public class EjectingCardState implements State {
    private final ATM atm;
    private final BackendAPI backendAPI;

    public EjectingCardState(ATM atm, BackendAPI atmBackendAPI) {
        this.atm = atm;
        this.backendAPI = atmBackendAPI;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Transaction cannot be initialized while ejecting card");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Card details and pin cannot be read while ejecting card");
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionID) {
        throw new IllegalStateException("Cash cannot be dispensed while ejecting card");
    }


    @Override
    public void ejectCard() {
        this.atm.changeState(new ReadyForTransactionState(this.atm, this.backendAPI));
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionID, double amount) {
        throw new IllegalStateException("Cash withdraw details cannot be read while ejecting card");
    }

    @Override
    public ATMState getState() {
        return ATMState.EJECTING_CARD;
    }
}
