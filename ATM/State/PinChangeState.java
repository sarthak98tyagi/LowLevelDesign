package ATM.State;

import ATM.Atm;
import ATM.Card;
import ATM.TransactionType;

public class PinChangeState implements State{
    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public boolean authenticatePin(Atm atm, long pin) {
        System.out.println("User already authenticated");
        return true;
    }

    @Override
    public void selectTransaction(Atm atm, TransactionType transactionType) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public long withdrawAmount(Atm atm, long amount) {
        System.out.println("Please select correct option");
        return 0;
    }

    @Override
    public long enquiryBalance(Atm atm) {
        System.out.println("Please select correct option");
        return 0;
    }

    @Override
    public void changePin(Atm atm, long newPin) {
        atm.getCard().setPin(newPin);
        System.out.println("Pin Reset Successful "+atm.getCard());
        exit(atm);
    }

    @Override
    public void exit(Atm atm) {
        returnCard(atm);
        atm.setState(new IdleState());
        System.out.println("Exiting...");
    }

    @Override
    public void returnCard(Atm atm) {
        atm.setCard(null);
        System.out.println("Please collect your card");
    }
}
