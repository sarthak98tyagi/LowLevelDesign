package PizzaShop;

public class WheatBase implements Pizza{

    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public String description() {
        return "Wheat Base";
    }
}
