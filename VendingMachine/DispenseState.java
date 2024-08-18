package VendingMachine;

public class DispenseState implements State{

    @Override
    public void pressAddMoneyButton(VendingMachine vendingMachine) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public void addMoney(VendingMachine vendingMachine, Money money) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public void pressSelectButton(VendingMachine vendingMachine) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        System.out.println("Transaction is in progress");
    }

    @Override
    public void dispense(VendingMachine vendingMachine, int code) {
        ItemShelf[] inventory = vendingMachine.getInventory().getInventory();
        ItemShelf selectedItemShelf = null;
        for(ItemShelf itemShelf: inventory){
            if(itemShelf.getCode()==code){
                selectedItemShelf = itemShelf;
                break;
            }
        }
        System.out.println("Dispatching Item "+ selectedItemShelf.getItem().getItemName());
        vendingMachine.setState(new IdealState());
    }

    @Override
    public long refund(VendingMachine vendingMachine) {
        return 0;
    }

    @Override
    public long change(VendingMachine vendingMachine, long remainingBalance) {
        return 0;
    }
}
