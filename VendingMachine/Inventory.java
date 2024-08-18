package VendingMachine;

public class Inventory {

    private ItemShelf[] inventory;

    public Inventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

}
