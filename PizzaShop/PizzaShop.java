package PizzaShop;

import java.util.ArrayList;
import java.util.List;

public class PizzaShop {
    private List<Order> orderList;
    private List<Item> menuList;
    private List<Customization> customizations;

    public PizzaShop(){
        this.orderList = new ArrayList<>();
        this.menuList = new ArrayList<>();
        this.customizations = new ArrayList<>();
    }

    public void displayMenu(){
        for(Item item: menuList){
            System.out.println(item.description());
        }
    }

    public void addOrder(Order order){
        orderList.add(order);
    }

    public void removeOrder(Order order){
        orderList.remove(order);
    }

    public void addItemInMenu(Item item){
        menuList.add(item);
    }

    public void removeItemFromMenu(Item item){
        menuList.remove(item);
    }

    public void addCustomization(Customization customization){
        customizations.add(customization);
    }

    public void removeCustomization(Customization customization){
        customizations.remove(customization);
    }
}
