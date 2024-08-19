package ATM.Withdrawal;

import ATM.Atm;

public class TwoThousandWithdraw extends Withdraw{

    public TwoThousandWithdraw(Withdraw next) {
        super(next);
    }

    @Override
    public String withdrawAmount(Atm atm, long amount) {
        long originalCount = atm.getTwoThousandCount();
        long totalCount = amount/2000;
        long remainingAmount = amount%2000;
        String output = "";
        if(totalCount<= atm.getTwoThousandCount()){
            output = totalCount+" of two thousand notes ";
            atm.setTwoThousandCount(atm.getTwoThousandCount()-totalCount);
        }
        else{
            output = atm.getTwoThousandCount()+" of two thousand notes ";
            remainingAmount = remainingAmount + (totalCount-atm.getTwoThousandCount())*2000;
            atm.setTwoThousandCount(0);
        }

        if(remainingAmount>0){
            String nextOutput = next.withdrawAmount(atm, remainingAmount);
            if(nextOutput.isEmpty()) {
                atm.setTwoThousandCount(originalCount);
                return nextOutput;
            }
            else
                output = output+nextOutput;
        }

        return output;
    }
}
