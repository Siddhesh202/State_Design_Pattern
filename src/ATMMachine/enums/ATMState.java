package ATMMachine.enums;

public enum ATMState {

    READY_FOR_TRANSACTION,
    READING_CARD_DETAILS_AND_PIN,
    DISPENSING_CASH,
    EJECTING_CARD,
    READING_CASH_WITHDRAW_DETAILS
}
