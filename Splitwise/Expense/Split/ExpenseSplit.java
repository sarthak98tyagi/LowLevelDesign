package Splitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {
    boolean validate(List<Split> splits, double amount);
}
