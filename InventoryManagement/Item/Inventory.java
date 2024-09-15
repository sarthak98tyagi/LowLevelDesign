package InventoryManagement.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    private String inventoryId;
    private List<Product> productList;

    public Inventory(String inventoryId){
        this.inventoryId = inventoryId;
        productList = new ArrayList<>();
    }

    public void addProducts(Map<String,Integer> productMap){
        //add units of product
    }

    public void removeProducts(Map<String,Integer> productMap){
        for(String productId: productMap.keySet()){
            for(Product product: productList){
                product.removeUnit(productMap.get(productId));
            }
        }
    }

    public void addProduct(Product product){
        productList.add(product);
        System.out.println("Product "+product.getProductName()+" "+product.getProductId()+" added to inventory");
    }

    public void removeProduct(Product product){
        for(Product pro: productList){
            if(pro.equals(product.getProductId())){
                productList.remove(pro);
            }
        }
        System.out.println("Product "+product.getProductName()+" "+product.getProductId()+" removed from inventory");
    }

    public Product getProduct(String productId){
        for(Product product: productList){
            if(productId.equals(product.getProductId()))
                    return product;
        }
        return null;
    }
}
