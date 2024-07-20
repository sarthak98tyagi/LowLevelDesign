package PizzaShop;

public class Mushroom implements Customization{

    private Pizza pizza;

    public Mushroom(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost()+50;
    }

    @Override
    public String description() {
        return pizza.description()+" Mushroom";
    }
}
