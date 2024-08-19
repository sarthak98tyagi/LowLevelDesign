package ATM.Withdrawal;

import ATM.Atm;

public class OneHundredWithdraw extends Withdraw{

    public OneHundredWithdraw(Withdraw next) {
        super(next);
    }

    @Override
    public String withdrawAmount(Atm atm, long amount) {
        long totalCount = amount/100;
        long remainingAmount = amount%100;
        String output = "";
        long deductedCount  = 0;
        if(totalCount<= atm.getHundredCount()){
            output = totalCount+" of one hundred notes ";
            atm.setHundredCount(atm.getHundredCount()-totalCount);
            deductedCount = totalCount;
        }
        else{
            output = atm.getHundredCount()+" of one hundred notes ";
            deductedCount = atm.getHundredCount();
            remainingAmount = remainingAmount + (totalCount-atm.getHundredCount())*100;
            atm.setHundredCount(0);
        }

        if(remainingAmount>0){
            String nextOutput = next.withdrawAmount(atm, remainingAmount);
            if(nextOutput.isEmpty()){
                atm.setHundredCount(atm.getHundredCount()+deductedCount);
                return nextOutput;
            }
            else
                output = output+nextOutput;
        }

        return output;
    }
}
