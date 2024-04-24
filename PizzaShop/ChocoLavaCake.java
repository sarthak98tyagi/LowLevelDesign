package PizzaShop;

public class ChocoLavaCake implements Item{
    @Override
    public double getCost() {
        return 70;
    }

    @Override
    public String description() {
        return "Choco Lava Cake";
    }
}
