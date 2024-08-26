package Splitwise.Expense.Split;

import Splitwise.User.User;

import java.util.List;

public class NonUniformExpenseSplit implements ExpenseSplit{

    @Override
    public boolean validate(List<Split> splits, double amount) {
        double nonUniformAmount = 0;
        for(Split split: splits){
            nonUniformAmount+=split.getAmount();
            if(nonUniformAmount>amount)
                return false;
        }
        return nonUniformAmount==amount;
    }
}
