package PizzaShop;

public class Olive implements Customization{

    private Pizza pizza;

    public Olive(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost()+30;
    }

    @Override
    public String description() {
        return pizza.description()+" Olive";
    }
}
