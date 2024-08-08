package Elevator;

public class InternalButtonDispatcher {

    public void submitRequest(int floor, Direction direction, int elevatorId){
        ElevatorSystem.INSTANCE.getElevatorControllerList().get(elevatorId).acceptRequest(floor,direction);
    }
}
