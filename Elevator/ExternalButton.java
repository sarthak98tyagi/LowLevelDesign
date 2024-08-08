package Elevator;

public class ExternalButton {

    ExternalButtonDispatcher externalButtonDispatcher;

    public ExternalButton(){
        externalButtonDispatcher = new ExternalButtonDispatcher();
    }

    public void pressButton(int floor, Direction direction) {
        externalButtonDispatcher.submitRequest(floor,direction);
    }

}
