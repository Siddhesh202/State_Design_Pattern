package ATMMachine.service;

import ATMMachine.models.Card;

public interface CardManagerService {

    public boolean validateCard(Card card, String pin);

    public boolean validateWithdrawalAmount(Card card, double amount);

    public boolean doTransaction(Card card, double amount, int transactionID);
}
