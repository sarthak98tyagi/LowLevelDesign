package PizzaShop;

public class PanPizza implements Customization{

    private Pizza pizza;
    @Override
    public double getCost() {
        return pizza.getCost()+89;
    }

    @Override
    public String description() {
        return pizza.description()+"\nPan Pizza";
    }
}
