package ATMMachine.factory;

import ATMMachine.enums.CardType;
import ATMMachine.service.CardManagerService;
import ATMMachine.service.CreditCardManagerService;
import ATMMachine.service.DebitCardManagerService;

public class CardManagerFactory {

    public static CardManagerService getCardManagerService(CardType cardType) {
        if(cardType == CardType.DEBIT) {
            return new DebitCardManagerService();
        } else if(cardType == CardType.CREDIT) {
            return new CreditCardManagerService();
        }
        return null;
    }
}
