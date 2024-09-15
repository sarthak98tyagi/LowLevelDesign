package InventoryManagement.User;

import InventoryManagement.Item.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,Integer> productMap;
    private double cartTotalAmount;

    public Cart(){
        productMap = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        System.out.println("Product: "+product.getProductId()+" "+product.getProductName()+" added, quantity: "+quantity);
        productMap.put(product.getProductId(),productMap.getOrDefault(product.getProductId(),0)+quantity);
        cartTotalAmount = cartTotalAmount + (product.getPrice()*quantity);
        System.out.println("Cart total "+cartTotalAmount);
    }

    public void removeProduct(Product product, int quantity){
        System.out.println("Product removed "+product.getProductName());
        if(productMap.containsKey(product.getProductId())){
            quantity = Math.min(quantity,productMap.get(product.getProductId()));
            productMap.put(product.getProductId(),productMap.get(product.getProductId()) - quantity);
            cartTotalAmount = cartTotalAmount - product.getPrice()*quantity;
            System.out.println("Cart total "+cartTotalAmount);
        }
        else{
            System.out.println("Product not in cart");
        }
    }

    public Map<String, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Integer> productMap) {
        this.productMap = productMap;
    }

    public double getCartTotalAmount() {
        return cartTotalAmount;
    }

    public void setCartTotalAmount(double cartTotalAmount) {
        this.cartTotalAmount = cartTotalAmount;
    }
}
