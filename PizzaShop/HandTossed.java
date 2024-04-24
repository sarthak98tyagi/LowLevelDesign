package PizzaShop;

public class HandTossed implements Customization{

    private Pizza pizza;


    @Override
    public double getCost() {
        return pizza.getCost()+29;
    }

    @Override
    public String description() {
        return pizza.description()+"\nHand Tossed";
    }
}
