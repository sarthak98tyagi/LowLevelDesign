package VendingMachine;

public interface State {
    void pressAddMoneyButton(VendingMachine vendingMachine);
    void addMoney(VendingMachine vendingMachine, Money money);
    void cancel(VendingMachine vendingMachine);
    void pressSelectButton(VendingMachine vendingMachine);
    void selectItem(VendingMachine vendingMachine,int code);
    void dispense(VendingMachine vendingMachine, int code);
    long refund(VendingMachine vendingMachine);
    long change(VendingMachine vendingMachine, long remainingBalance);
}
