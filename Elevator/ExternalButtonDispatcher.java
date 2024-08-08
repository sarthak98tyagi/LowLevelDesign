package Elevator;

public class ExternalButtonDispatcher {

    public void submitRequest(int floor, Direction direction){
        int elevatorId = ElevatorSystem.INSTANCE.getElevatorSelectionStrategy().selectElevator(floor,direction);
        ElevatorSystem.INSTANCE.getElevatorControllerList().get(elevatorId).acceptRequest(floor,direction);
    }

}
