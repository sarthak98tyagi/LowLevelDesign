package Splitwise.BalanceSheet;

import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateBalanceSheet(User paidBy, List<Split> splits, double amount){
        for(Split split: splits){
            BalanceSheet balanceSheet = split.getMember().getBalanceSheet();
            if(split.getMember().getUserId().equals(paidBy.getUserId())){
                System.out.println("Payment done by "+paidBy.getName()+", Expense: "+split.getAmount());
                balanceSheet.setTotalExpenditure(balanceSheet.getTotalExpenditure()+split.getAmount());
                balanceSheet.setTotalPayment(balanceSheet.getTotalPayment()+amount);
            }
            else{
                System.out.println(split.getMember().getName()+" owe Rupees: "+split.getAmount()+" to "+paidBy.getName());
                //update Payer's map
                Map<User,Balance> payerBalanceMap  = paidBy.getBalanceSheet().getBalanceMap();
                Balance payerMemberBalance = payerBalanceMap.getOrDefault(split.getMember(),new Balance(0,0));
                payerMemberBalance.setGetBack(payerMemberBalance.getGetBack()+split.getAmount());
                payerBalanceMap.put(split.getMember(),payerMemberBalance);
                paidBy.getBalanceSheet().setBalanceMap(payerBalanceMap);
                paidBy.getBalanceSheet().setTotalGetBack(paidBy.getBalanceSheet().getTotalGetBack()+ split.getAmount());


                //update Payee's Map
                Map<User,Balance> memberBalanceMap = balanceSheet.getBalanceMap();
                Balance memberPayerBalance = memberBalanceMap.getOrDefault(paidBy,new Balance(0,0));
                memberPayerBalance.setOwe(memberPayerBalance.getOwe()+split.getAmount());
                memberBalanceMap.put(paidBy,memberPayerBalance);
                split.getMember().getBalanceSheet().setBalanceMap(memberBalanceMap);

                //
                balanceSheet.setTotalExpenditure(balanceSheet.getTotalExpenditure()+split.getAmount());
                balanceSheet.setTotalOwe(balanceSheet.getTotalOwe()+ split.getAmount());
            }
        }
    }




}
