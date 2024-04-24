package PizzaShop;

public class CornPizza implements Pizza{

    Size size;

    public CornPizza(Size size) {
        this.size = size;
    }

    @Override
    public double getCost() {
        switch (size){
            case REGULAR -> {
                return 140;
            }
            case MEDIUM -> {
                return 230;
            }
            case LARGE -> {
                return 399;
            }
            default -> {
                //throw exception
                return 0;
            }
        }
    }

    @Override
    public String description() {
        return "Corn Pizza";
    }
}
