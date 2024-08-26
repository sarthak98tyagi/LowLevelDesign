package Splitwise.Expense.Split;

import Splitwise.User.User;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit{
    @Override
    public boolean validate(List<Split> splits, double amount) {
        int per = 0;
        for(Split split: splits){
            per+=split.getPercentage();
        }
        return per==100;
    }
}
