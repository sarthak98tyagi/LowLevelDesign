package PizzaShop;

public class CheeseBurst implements Customization{

    private Pizza pizza;

    public CheeseBurst(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost()+59;
    }

    @Override
    public String description() {
        return pizza.description()+"\nCheese Burst";
    }
}
