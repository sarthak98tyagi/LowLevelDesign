package PizzaShop;

public class GarlicBread implements Item {

    @Override
    public double getCost() {
        return 60;
    }

    @Override
    public String description() {
        return "Garlic Bread";
    }
}
