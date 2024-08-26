package Splitwise.User;

import Splitwise.BalanceSheet.BalanceSheet;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private BalanceSheet balanceSheet;

    public User(String name, BalanceSheet balanceSheet) {
        userId = UUID.randomUUID().toString();
        this.name = name;
        this.balanceSheet = balanceSheet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public void displayBalanceSheet(){
        System.out.println("Balance Sheet for "+name);
        balanceSheet.printBalanceSheet();
    }
}
