package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.models.Card;

public interface State {

    int initTransaction(); // returns a transaction ID

    boolean readCardDetailsAndPin(Card card, String pin); // returns true if card details and pin are correct

    int dispenseCash(Card card, double amount, int transactionID);

    void ejectCard();

    boolean cancelTransaction(int transactionId); // returns true if transaction is cancelled and false otherwise

    boolean readCashWithdrawDetails(Card card, int transactionId, double amount); // returns true if cash withdraw details are correct

    ATMState getState();
}
