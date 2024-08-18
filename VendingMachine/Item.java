package VendingMachine;

public class Item {

    private String itemName;
    private ItemType itemType;
    private long price;

    public Item(String itemName, ItemType itemType, long price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
