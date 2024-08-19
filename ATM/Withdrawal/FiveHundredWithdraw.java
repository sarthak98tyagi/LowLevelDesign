package ATM.Withdrawal;

import ATM.Atm;

public class FiveHundredWithdraw extends Withdraw{

    public FiveHundredWithdraw(Withdraw next) {
        super(next);
    }

    @Override
    public String withdrawAmount(Atm atm, long amount) {
        long totalCount = amount/500;
        long remainingAmount = amount%500;
        String output = "";
        long deductedCount=0;
        if(totalCount<= atm.getFiveHundredCount()){
            output = totalCount+" of five hundred notes ";
            atm.setFiveHundredCount(atm.getFiveHundredCount()-totalCount);
            deductedCount = totalCount;
        }
        else{
            output = atm.getFiveHundredCount()+" of five hundred notes ";
            deductedCount = atm.getFiveHundredCount();
            remainingAmount = remainingAmount + (totalCount-atm.getFiveHundredCount())*500;
            atm.setFiveHundredCount(0);
        }

        if(remainingAmount>0){
            String nextOutput = next.withdrawAmount(atm, remainingAmount);
            if(nextOutput.isEmpty()) {
                atm.setFiveHundredCount(atm.getFiveHundredCount()+deductedCount);
                return nextOutput;
            }
            else
                output = output+nextOutput;
        }

        return output;
    }
}
