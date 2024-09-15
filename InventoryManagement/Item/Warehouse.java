package InventoryManagement.Item;

import InventoryManagement.Address;

import java.util.Map;

public class Warehouse {

    private String warehouseId;
    private Address address;
    private Inventory inventory;

    public Warehouse(String warehouseId, Address address, Inventory inventory) {
        this.warehouseId = warehouseId;
        this.address = address;
        this.inventory = inventory;
    }

    public void addProducts(Map<String,Integer> productMap){
        inventory.addProducts(productMap);
    }

    public void removeProducts(Map<String,Integer> productMap){
        inventory.removeProducts(productMap);
    }


    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
