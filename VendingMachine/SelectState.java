package VendingMachine;

import java.util.List;

public class SelectState implements State{
    @Override
    public void pressAddMoneyButton(VendingMachine vendingMachine) {
        System.out.println("Money already added, To add again please cancel the transaction first");

    }

    @Override
    public void addMoney(VendingMachine vendingMachine, Money money) {
        System.out.println("Money already added, To add again please cancel the transaction first");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Cancelling the transaction ");
        refund(vendingMachine);
        vendingMachine.setState(new IdealState());
    }

    @Override
    public void pressSelectButton(VendingMachine vendingMachine) {
        System.out.println("Please enter item code");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        ItemShelf[] inventory = vendingMachine.getInventory().getInventory();
        ItemShelf selectedItemShelf = null;
        for(ItemShelf itemShelf: inventory){
            if(itemShelf.getCode()==code){
                selectedItemShelf = itemShelf;
                break;
            }
        }

        if(selectedItemShelf==null || !selectedItemShelf.isAvailable() || selectedItemShelf.getItem().getPrice()> vendingMachine.getLastAmountAdded()){
            System.out.println("Transaction Cancelled");
            refund(vendingMachine);
            vendingMachine.setState(new IdealState());
        }
        else{
            long remainingBalance = vendingMachine.getLastAmountAdded()-selectedItemShelf.getItem().getPrice();
            if(remainingBalance>0){
                System.out.println("Please collect change from cash tray");
                change(vendingMachine,remainingBalance);
            }
            vendingMachine.setState(new DispenseState());
            vendingMachine.getState().dispense(vendingMachine,code);
        }

    }

    @Override
    public void dispense(VendingMachine vendingMachine, int code) {return;}

    @Override
    public long refund(VendingMachine vendingMachine) {
        long refund=0;
        if(vendingMachine.getLastAmountAdded()==0){
            System.out.println("No refund to process");
        }
        else{
            List<CurrencyMap> currencyMap = vendingMachine.getCurrencyMap();
            for(Money money: vendingMachine.getAddedMoney()){
                refund += money.value;
                for(CurrencyMap currency: currencyMap){
                    if(currency.getCurrency()==money){
                        currency.setCount(Math.max(currency.getCount()-1,0));
                    }
                }
            }
            vendingMachine.setTotalMoney(vendingMachine.getTotalMoney()- vendingMachine.getLastAmountAdded());
            vendingMachine.setLastAmountAdded(0L);
            System.out.println("Processing total refund: "+refund);
        }
        return refund;
    }

    @Override
    public long change(VendingMachine vendingMachine, long remainingBalance) {
        vendingMachine.setTotalMoney(vendingMachine.getTotalMoney()-remainingBalance);
        //logic to update currency notes in currencyMap object
        System.out.println("Change amount: "+remainingBalance);
        return remainingBalance;
    }
}
