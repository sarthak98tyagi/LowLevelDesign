package PizzaShop;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> orderedItems;

    boolean isCompleted;

    public Order(){
        orderedItems = new ArrayList<>();
        isCompleted = false;
    }

    public void addItem(Item item){
        orderedItems.add(item);
    }

    public void removeItem(Item item){
        orderedItems.remove(item);
    }

    public void setCompleted(){
        isCompleted=true;
    }

    public double getTotalCost(){
        double price = 0;
        for(Item item: orderedItems){
            price += item.getCost();
        }
        return price+calculateTax(price);
    }

    private double calculateTax(double price) {
        return price+(0.05*price);
    }


}
