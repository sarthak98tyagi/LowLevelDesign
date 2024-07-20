package PizzaShop;

public class Corn implements Customization{

    private Pizza pizza;


    @Override
    public double getCost() {
        return pizza.getCost()+40;
    }

    @Override
    public String description() {
        return pizza.description()+" Corn";
    }
}
