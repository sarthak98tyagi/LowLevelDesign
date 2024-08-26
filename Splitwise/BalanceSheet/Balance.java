package Splitwise.BalanceSheet;

public class Balance {
    private double owe;
    private double getBack;

    public Balance(double owe, double getBack) {
        this.owe = owe;
        this.getBack = getBack;
    }

    public double getOwe() {
        return owe;
    }

    public void setOwe(double owe) {
        this.owe = owe;
    }

    public double getGetBack() {
        return getBack;
    }

    public void setGetBack(double getBack) {
        this.getBack = getBack;
    }
}
