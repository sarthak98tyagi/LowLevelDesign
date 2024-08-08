package Elevator;

public class InternalButton{

    InternalButtonDispatcher internalButtonDispatcher;

    public InternalButton(){
        internalButtonDispatcher = new InternalButtonDispatcher();
    }

    public void pressButton(int floor, Direction direction, int elevatorId) {
        internalButtonDispatcher.submitRequest(floor,direction,elevatorId);
    }

}
