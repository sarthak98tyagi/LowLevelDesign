package Splitwise.BalanceSheet;

import Splitwise.User.User;

import java.util.Map;

public class BalanceSheet {

    private Map<User,Balance> balanceMap;
    private double totalExpenditure;
    private double totalPayment;
    private double totalOwe;
    private double totalGetBack;

    public BalanceSheet(Map<User, Balance> balanceMap, double totalExpenditure, double totalPayment, double totalOwe, double totalGetBack) {
        this.balanceMap = balanceMap;
        this.totalExpenditure = totalExpenditure;
        this.totalPayment = totalPayment;
        this.totalOwe = totalOwe;
        this.totalGetBack = totalGetBack;
    }

    public Map<User, Balance> getBalanceMap() {
        return balanceMap;
    }

    public void setBalanceMap(Map<User, Balance> balanceMap) {
        this.balanceMap = balanceMap;
    }

    public double getTotalExpenditure() {
        return totalExpenditure;
    }

    public void setTotalExpenditure(double totalExpenditure) {
        this.totalExpenditure = totalExpenditure;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }

    public void printBalanceSheet(){
        System.out.println("Total Expense: "+totalExpenditure+" Rupees"
                +"\nTotal Payment: "+totalPayment+" Rupees"
                +"\nTotal Owe: "+totalOwe+" Rupees"
                +"\nTotal Get Back: "+totalGetBack);
        System.out.println("Detailed View");
        for(Map.Entry<User,Balance> entry: balanceMap.entrySet()){
            System.out.println("Amount owed to "+entry.getKey().getName()+" : "+entry.getValue().getOwe()+" Rupees");
            System.out.println("Amount get back from "+entry.getKey().getName()+" : "+entry.getValue().getGetBack()+" Rupees");
        }
    }
}
