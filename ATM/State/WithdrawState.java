package ATM.State;

import ATM.Atm;
import ATM.Card;
import ATM.TransactionType;
import ATM.Withdrawal.FiveHundredWithdraw;
import ATM.Withdrawal.OneHundredWithdraw;
import ATM.Withdrawal.TwoThousandWithdraw;
import ATM.Withdrawal.Withdraw;

public class WithdrawState implements State{

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Transaction is already in progress");
    }

    @Override
    public boolean authenticatePin(Atm atm, long pin) {
        System.out.println("User is already authenticated");
        return true;
    }

    @Override
    public void selectTransaction(Atm atm, TransactionType transactionType) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public long withdrawAmount(Atm atm, long amount) {

        if(atm.getCard().getBankAccount().getBalance()<amount){
            System.out.println("Insufficient Balance");
            exit(atm);
            return 0;
        }
        if(atm.getAmount()<amount){
            System.out.println("ATM is out of service");
            exit(atm);
            return 0;
        }
        Withdraw withdrawer = new TwoThousandWithdraw(new FiveHundredWithdraw(new OneHundredWithdraw(null)));
        String output = withdrawer.withdrawAmount(atm,amount);
        if(output.isEmpty()){
            System.out.println("ATM is out of service");
            exit(atm);
            return 0;
        }
        atm.getCard().getBankAccount().setBalance(atm.getCard().getBankAccount().getBalance()-amount);
        System.out.println("Please Collect cash "+output);
        exit(atm);
        return amount;

    }

    @Override
    public long enquiryBalance(Atm atm) {
        System.out.println("Transaction is in progress");
        return 0;
    }

    @Override
    public void changePin(Atm atm, long newPin) {
        System.out.println("Transaction is in progress");
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
