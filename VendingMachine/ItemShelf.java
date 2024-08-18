package VendingMachine;

public class ItemShelf {

    private int code;
    private Item item;
    private int quantity;
    private boolean isAvailable;

    public ItemShelf(int code, Item item, int quantity) {
        this.code = code;
        this.item = item;
        this.quantity = quantity;
        isAvailable = this.quantity>0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



}
