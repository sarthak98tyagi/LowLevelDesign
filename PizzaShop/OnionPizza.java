package PizzaShop;

public class OnionPizza implements Pizza{
    private Size size;

    public OnionPizza(Size size) {
        this.size = size;
    }

    @Override
    public double getCost() {
        switch (size){
            case REGULAR -> {
                return 130;
            }
            case MEDIUM -> {
                return 200;
            }
            case LARGE -> {
                return 369;
            }
            default -> {
                //throw exception
                return 0;
            }
        }
    }

    @Override
    public String description() {
        return "Onion Pizza";
    }

}
