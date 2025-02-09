package ATMMachine.state;

import ATMMachine.apis.BackendAPI;
import ATMMachine.enums.ATMState;
import ATMMachine.factory.CardManagerFactory;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;
import ATMMachine.service.CardManagerService;

public class ReadingCashWithdrawDetailsState implements State {

    private final ATM atm;
    private final BackendAPI atmBackendAPI;
    public ReadingCashWithdrawDetailsState(ATM atm, BackendAPI atmBackendAPI) {
        this.atm = atm;
        this.atmBackendAPI = atmBackendAPI;
    }

    @Override
    public int initTransaction() {
        return 0;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        return false;
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionID) {
        throw new IllegalStateException("Cash cannot be dispensed while reading cash withdraw details");
    }


    @Override
    public void ejectCard() {
        throw new IllegalStateException("Card cannot be ejected while reading cash withdraw details");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionID, double amount) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        assert cardManagerService != null;

        boolean isCashWithdrawDetailsValid = cardManagerService.validateWithdrawalAmount(card, amount);

        if(isCashWithdrawDetailsValid) {
            atm.changeState(new DispensingCashState(this.atm, this.atmBackendAPI));
        } else {
            atm.changeState(new EjectingCardState(this.atm, this.atmBackendAPI));
        }

        return isCashWithdrawDetailsValid;
    }

    @Override
    public ATMState getState() {
        return ATMState.READING_CASH_WITHDRAW_DETAILS;
    }
}
