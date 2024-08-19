package ATM.State;

import ATM.Atm;
import ATM.Card;
import ATM.TransactionType;

public class HasCardState implements State{
    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public boolean authenticatePin(Atm atm, long pin) {
        boolean validated = atm.getCard().getPin()==pin;
        System.out.println("Authentication "+ (validated?"successful":"failed"));
        atm.setState(new SelectionState());
        return validated;
    }

    @Override
    public void selectTransaction(Atm atm, TransactionType transactionType) {
        System.out.println("Pin Authentication Pending");
    }

    @Override
    public long withdrawAmount(Atm atm, long amount) {
        System.out.println("Pin Authentication Pending");
        return 0;
    }

    @Override
    public long enquiryBalance(Atm atm) {
        System.out.println("Pin Authentication Pending");
        return 0;
    }

    @Override
    public void changePin(Atm atm, long newPin) {
        System.out.println("Pin Authentication Pending");
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
