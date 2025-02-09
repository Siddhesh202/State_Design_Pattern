package ATMMachine.state;

import ATMMachine.apis.BackendAPI;
import ATMMachine.enums.ATMState;
import ATMMachine.factory.CardManagerFactory;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;
import ATMMachine.service.CardManagerService;
import ATMMachine.service.CashDispenserService;
import ATMMachine.service.CashDispenserServiceImpl;

public class DispensingCashState implements State {
    private final ATM atm;
    private final BackendAPI atmBackendAPI;

    private final CashDispenserService cashDispenserService;
    public DispensingCashState(ATM atm, BackendAPI atmBackendAPI) {
        this.atm = atm;
        this.atmBackendAPI = atmBackendAPI;
        this.cashDispenserService = new CashDispenserServiceImpl(atmBackendAPI);
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Transaction cannot be initialized while dispensing cash");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Card details and pin cannot be read while dispensing cash");
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionID) {
        // Logic to dispense cash
        CardManagerService manager = CardManagerFactory.getCardManagerService(card.getCardType());
        assert manager != null;
        boolean isTxnSuccessful = manager.doTransaction(card, amount, transactionID);
        if(isTxnSuccessful) {
            this.cashDispenserService.dispenseCash(this.atm, amount);

        } else {
            System.out.println("Something went wrong");
        }
        this.atm.changeState(new EjectingCardState(this.atm, this.atmBackendAPI));

        return Integer.parseInt(String.valueOf(amount));
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Card cannot be ejected while dispensing cash");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Transaction cannot be cancelled while dispensing cash");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, double amount) {
        throw new IllegalStateException("Cash withdraw details cannot be read while dispensing cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.DISPENSING_CASH;
    }
}
