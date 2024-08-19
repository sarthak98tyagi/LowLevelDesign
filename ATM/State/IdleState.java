package ATM.State;

import ATM.Atm;
import ATM.Card;
import ATM.TransactionType;

public class IdleState implements State{

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card Inserted...");
        atm.setCard(card);
        atm.setState(new HasCardState());
    }

    @Override
    public boolean authenticatePin(Atm atm, long pin) {
        System.out.println("Please insert card");
        return false;
    }

    @Override
    public void selectTransaction(Atm atm, TransactionType transactionType) {
        System.out.println("Please insert card");
    }

    @Override
    public long withdrawAmount(Atm atm, long amount) {
        System.out.println("Please insert card");
        return 0;
    }

    @Override
    public long enquiryBalance(Atm atm) {
        System.out.println("Please insert card");
        return 0;
    }

    @Override
    public void changePin(Atm atm, long newPin) {
        System.out.println("Please insert card");
    }

    @Override
    public void exit(Atm atm) {
        System.out.println("Please insert card");
    }

    @Override
    public void returnCard(Atm atm) {
        System.out.println("Please insert card");
    }
}
