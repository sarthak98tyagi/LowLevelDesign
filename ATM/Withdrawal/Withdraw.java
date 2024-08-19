package ATM.Withdrawal;

import ATM.Atm;

public class Withdraw {

    Withdraw next;

    public Withdraw(Withdraw next){
        this.next = next;
    }

    public String withdrawAmount(Atm atm, long amount) {
        if(next!=null){
            return next.withdrawAmount(atm, amount);
        }
        else{
            return "";
        }
    }
}
