package Splitwise.Expense;

import Splitwise.Expense.Split.Split;
import Splitwise.Expense.Split.SplitType;
import Splitwise.User.User;

import java.util.List;
import java.util.UUID;

public class Expense {

    private String expenseID;
    private String title;
    private SplitType splitType;
    private List<Split> splits;
    private User paidBy;
    private double amount;

    public Expense(String title, SplitType splitType, List<Split> splits, User paidBy, double amount) {
        this.expenseID = UUID.randomUUID().toString();
        this.title = title;
        this.splitType = splitType;
        this.splits = splits;
        this.paidBy = paidBy;
        this.amount = amount;
    }

    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
