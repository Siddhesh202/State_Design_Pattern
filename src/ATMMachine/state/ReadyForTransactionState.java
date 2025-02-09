package ATMMachine.state;
import ATMMachine.DTO.CreateTransactionDTO;
import ATMMachine.apis.BackendAPI;
import ATMMachine.enums.ATMState;
import ATMMachine.models.Card;
import ATMMachine.models.ATM;

public class ReadyForTransactionState implements State{

    private final ATM atm;
    private final BackendAPI atmBackendAPI;

    public ReadyForTransactionState(ATM atm, BackendAPI backendAPI) {
        this.atm = atm;
        this.atmBackendAPI = backendAPI;
    }

    @Override
    public int initTransaction() {
        CreateTransactionDTO createTransactionDTO = new CreateTransactionDTO(atm.getAtmID());
        int transactionId =  atmBackendAPI.createTransaction(createTransactionDTO);

        if(transactionId == 0) {
            throw new IllegalStateException("Transaction could not be created");
        }

        // update state to READING_CARD_DETAILS_AND_PIN
        atm.changeState(new ReadCardDetailsAndPinState(atm, atmBackendAPI));

        // return the transaction ID
        return transactionId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Card details and pin cannot be read in ReadyForTransaction state");
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionID) {
        throw new IllegalStateException("Cash cannot be dispensed in ReadyForTransaction state");
    }


    @Override
    public void ejectCard() {
        throw new IllegalStateException("Card cannot be ejected in ReadyForTransaction state");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionID, double amount) {
        throw new IllegalStateException("Cash withdraw details cannot be read in ReadyForTransaction state");
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
