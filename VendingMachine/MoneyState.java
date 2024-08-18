package VendingMachine;

import java.util.List;

public class MoneyState implements State {

    @Override
    public void pressAddMoneyButton(VendingMachine vendingMachine) {
        System.out.println("Please add money");
    }

    @Override
    public void addMoney(VendingMachine vendingMachine, Money money) {
        vendingMachine.getAddedMoney().add(money);
        vendingMachine.setLastAmountAdded(vendingMachine.getLastAmountAdded()+ money.value);
        vendingMachine.setTotalMoney(vendingMachine.getTotalMoney()+money.value);
        boolean currencyUpdated = false;
        for(CurrencyMap currency : vendingMachine.getCurrencyMap()){
            if(currency.getCurrency()==money){
                currencyUpdated = true;
                currency.setCount(currency.getCount()+1);
            }
        }
        if(!currencyUpdated){
            vendingMachine.getCurrencyMap().add(new CurrencyMap(money,1));
        }
        System.out.println("Added "+money.value);
        System.out.println("Total Amount Added for this transaction: "+vendingMachine.getLastAmountAdded());
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Cancelling the transaction ");
        refund(vendingMachine);
        vendingMachine.setState(new IdealState());
    }

    @Override
    public void pressSelectButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new SelectState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        System.out.println("Please press select item button first");
    }

    @Override
    public void dispense(VendingMachine vendingMachine, int code) {
        System.out.println("Please press select button first");
    }

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
        return 0L;
    }
}
