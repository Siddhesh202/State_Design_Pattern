package ATMMachine.models;

import ATMMachine.enums.CardNetworkType;
import ATMMachine.enums.CardType;

public class VisaDebitCard extends Card implements Debit, Visa {
    public VisaDebitCard(long cardNumber, int pin, String name, String bankName) {
        super(cardNumber, pin, name, CardType.DEBIT, bankName);
    }

    @Override
    public void makePinPayment() {
        this.connectToVisa();
        System.out.println("Making a payment with Pin");
    }

    @Override
    public void connectToVisa() {
        System.out.println("Connecting to Visa");
    }
}
