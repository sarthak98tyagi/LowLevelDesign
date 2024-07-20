package PizzaShop;

public class Client {

    public static void main(String[] args){
        //To add a WheatBase Cheese Mushroom Pizza
        Pizza pizza = new Mushroom(new CheeseBurst(new WheatBase()));
        System.out.println("Added "+pizza.description()+" Pizza.\nPlease pay "+pizza.getCost()+" Rs");
    }

}
