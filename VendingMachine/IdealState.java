package VendingMachine;

import java.util.ArrayList;

public class IdealState implements State{

    @Override
    public void pressAddMoneyButton(VendingMachine vendingMachine) {
        vendingMachine.setLastAmountAdded(0L);
        vendingMachine.setAddedMoney(new ArrayList<>());
        vendingMachine.setState(new MoneyState());
    }

    @Override
    public void addMoney(VendingMachine vendingMachine, Money money) {
        System.out.println("Please press add money button first");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Please start transaction first, Nothing to cancel");
    }

    @Override
    public void pressSelectButton(VendingMachine vendingMachine) {
        System.out.println("Please press add money button first");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        System.out.println("Please press add money button first");
    }

    @Override
    public void dispense(VendingMachine vendingMachine, int code) {
        System.out.println("Please press add money button first");
    }

    @Override
    public long refund(VendingMachine vendingMachine) {
        System.out.println("Please press add money button first");
        return 0;
    }

    @Override
    public long change(VendingMachine vendingMachine, long remainingBalance) {
        System.out.println("Please press add money button first");
        return 0;
    }

}
