package Splitwise.Expense.Split;

import java.util.List;

public class UniformExpenseSplit implements ExpenseSplit{

    @Override
    public boolean validate(List<Split> splits, double amount) {
        double uniformAmount = amount/splits.size();
        for(Split split: splits){
            if(split.getAmount()!=uniformAmount)
                return false;
        }
        return true;
    }

}
