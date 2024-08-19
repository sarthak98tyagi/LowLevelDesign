package ATM.State;

import ATM.Atm;
import ATM.Card;
import ATM.TransactionType;

public class SelectionState implements State{

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card Already Inserted");
    }

    @Override
    public boolean authenticatePin(Atm atm, long pin) {
        System.out.println("Authentication Successful");
        return true;
    }

    @Override
    public void selectTransaction(Atm atm, TransactionType transactionType) {
        System.out.println("Transaction Type "+transactionType);
        switch (transactionType){
            case WITHDRAW -> atm.setState(new WithdrawState());
            case CHANGE_PIN -> atm.setState(new PinChangeState());
            case BALANCE_ENQUIRY -> atm.setState(new EnquiryState());
            default -> exit(atm);
        }
    }

    @Override
    public long withdrawAmount(Atm atm, long amount) {
        System.out.println("Please Enter Amount");
        return 0;
    }

    @Override
    public long enquiryBalance(Atm atm) {
        System.out.println("Please select correct transaction");
        return 0;
    }

    @Override
    public void changePin(Atm atm, long newPin) {
        System.out.println("Please select correct option");
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
