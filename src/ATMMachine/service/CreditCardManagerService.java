package ATMMachine.service;

import ATMMachine.models.Card;

public class CreditCardManagerService implements CardManagerService{

    @Override
    public boolean validateCard(Card card, String pin) {
        return true;
    }

    @Override
    public boolean validateWithdrawalAmount(Card card, double amount) {
        return true;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionID) {
        return true;
    }
}
