package Splitwise.Expense.Split;

import Splitwise.User.User;

public class Split {
    private User member;
    private double amount;
    private int percentage;

    public Split(User member, double amount, int percentage) {
        this.member = member;
        this.amount = amount;
        this.percentage = percentage;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

}
