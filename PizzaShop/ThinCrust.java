package PizzaShop;

public class ThinCrust implements Pizza{

    @Override
    public double getCost() {
        return 90;
    }

    @Override
    public String description() {
        return "Thin Crust";
    }

}
