package Splitwise.Expense;

import Splitwise.BalanceSheet.BalanceSheetController;
import Splitwise.Expense.Split.ExpenseSplit;
import Splitwise.Expense.Split.Split;
import Splitwise.Expense.Split.SplitFactory;
import Splitwise.Expense.Split.SplitType;
import Splitwise.User.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController(BalanceSheetController balanceSheetController) {
        this.balanceSheetController = balanceSheetController;
    }

    public Expense createExpense(String title, SplitType splitType, List<Split> splits, User paidBy, double amount){
        ExpenseSplit splitValidator = new SplitFactory().getExpenseSplit(splitType);
        boolean validExpense = splitValidator.validate(splits,amount);
        if(validExpense){
            Expense expense = new Expense(title,splitType,splits,paidBy,amount);
            if(splitType==SplitType.PERCENTAGE){
                calPerc(splits,amount);
            }
            System.out.println("Updating BalanceSheet");
            balanceSheetController.updateBalanceSheet(paidBy,splits,amount);
            return expense;
        }
        else {
            System.out.println("Invalid Split");
            return null;
        }
    }

    private void calPerc(List<Split> splits, double amount){
        for(Split split: splits){
            split.setAmount(amount*(split.getPercentage()*0.01));
        }
    }

}
