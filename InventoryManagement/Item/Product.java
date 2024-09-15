package InventoryManagement.Item;

import java.util.List;

public class Product {
    private String productId;
    private String productName;
    private String brandName;
    private double price;
    private List<Unit> unitList;

    public Product(String productId, String productName, String brandName, double price, List<Unit> unitList) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
        this.unitList = unitList;
    }

    public void addUnit(Unit unit){
        unitList.add(unit);
    }

    public void removeUnit(int count){
        for(int i=0;i<count;i++)
            unitList.remove(0);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }
}
