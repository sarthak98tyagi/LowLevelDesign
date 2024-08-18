package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineClient {

    public static void main(String[] args) {
        Inventory inventory = createInventory(9);
        displayInventory(inventory);
    }

    private static void displayInventory(Inventory inventory) {
        int partitionSize = inventory.getInventory().length/3;
        for(int i=0;i<inventory.getInventory().length;i++){
            ItemShelf itemShelf = inventory.getInventory()[i];
            System.out.print("| Item: "+itemShelf.getItem().getItemName()+" Code: "+itemShelf.getCode()+" Price: "+itemShelf.getItem().getPrice()+" |");
            if((i+1)%partitionSize==0)
                System.out.println();
        }
        VendingMachine vendingMachine = new VendingMachine(inventory,new IdealState());
        vendingMachine.getState().pressAddMoneyButton(vendingMachine);
        vendingMachine.getState().addMoney(vendingMachine,Money.FIFTY);
        vendingMachine.getState().pressSelectButton(vendingMachine);
        vendingMachine.getState().selectItem(vendingMachine,7);
    }

    private static Inventory createInventory(int size) {
        ItemShelf[] itemShelves = new ItemShelf[size];
        List<Item> itemsList = new ArrayList<>();
        itemsList.add(new Item("Coca-Cola",ItemType.SOFT_DRINK,20));
        itemsList.add(new Item("Pepsi",ItemType.SOFT_DRINK,20));
        itemsList.add(new Item("Slice",ItemType.SOFT_DRINK,30));
        itemsList.add(new Item("Lays",ItemType.SNACK,10));
        itemsList.add(new Item("Kurkure",ItemType.SNACK,10));
        itemsList.add(new Item("Mad Angles",ItemType.SNACK,15));
        itemsList.add(new Item("Dairy Milk",ItemType.CHOCOLATE,50));
        itemsList.add(new Item("Five Star",ItemType.CHOCOLATE,30));
        itemsList.add(new Item("Kit Kat",ItemType.CHOCOLATE,50));
        for(int i=0;i<size;i++){
            itemShelves[i] = new ItemShelf(i,itemsList.get(i),10);
        }
        Inventory inventory = new Inventory(itemShelves);
        return inventory;
    }


}
