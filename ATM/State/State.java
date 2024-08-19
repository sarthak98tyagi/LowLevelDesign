package ATM.State;

import ATM.Atm;
import ATM.Card;
import ATM.TransactionType;

public interface State {
    void insertCard(Atm atm, Card card);
    boolean authenticatePin(Atm atm, long pin);
    void selectTransaction(Atm atm, TransactionType transactionType);
    long withdrawAmount(Atm atm, long amount);
    long enquiryBalance(Atm atm);
    void changePin(Atm atm, long newPin);
    void exit(Atm atm);
    void returnCard(Atm atm);
}
