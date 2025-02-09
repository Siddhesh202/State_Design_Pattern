package ATMMachine.state;

import ATMMachine.apis.BackendAPI;
import ATMMachine.enums.ATMState;
import ATMMachine.factory.CardManagerFactory;
import ATMMachine.models.Card;
import ATMMachine.models.ATM;
import ATMMachine.apis.BackendAPI;
import ATMMachine.service.CardManagerService;

public class ReadCardDetailsAndPinState implements State {
    private final ATM atm;

    private final BackendAPI atmBackendAPI;

    public ReadCardDetailsAndPinState(ATM atm, BackendAPI atmBackendAPI) {
        this.atm = atm;
        this.atmBackendAPI = atmBackendAPI;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Transaction cannot be initialized while reading card details and pin");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        assert cardManagerService != null;
        boolean isCardValid = cardManagerService.validateCard(card, pin);

        if(isCardValid) {
            atm.changeState(new ReadingCashWithdrawDetailsState(this.atm, this.atmBackendAPI));
        } else {
            atm.changeState(new EjectingCardState(this.atm, this.atmBackendAPI));
        }

        return isCardValid;
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionID) {
        throw new IllegalStateException("Cash cannot be dispensed while reading card details and pin");
    }


    @Override
    public void ejectCard() {
        throw new IllegalStateException("Card cannot be ejected while reading card details and pin");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionID, double amount) {
        throw new IllegalStateException("Cash withdraw details cannot be read while reading card details and pin");
    }

    @Override
    public ATMState getState() {
        return ATMState.READING_CARD_DETAILS_AND_PIN;
    }
}
