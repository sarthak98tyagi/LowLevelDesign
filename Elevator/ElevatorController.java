package Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private  int elevatorControllerId;
    private ElevatorCar elevatorCar;
    private List<Request> pendingRequests;

    public ElevatorController(ElevatorCar elevatorCar){
        this.elevatorControllerId = elevatorCar.getElevatorId();
        this.elevatorCar = elevatorCar;
        this.pendingRequests = new ArrayList<>();
    }

    public void acceptRequest(int floor, Direction direction){
        System.out.println("Request added for floor "+floor+" towards "+direction+ " in elevator "+elevatorControllerId);
        pendingRequests.add(new Request(floor,direction));
        controlCar();
    }

    private void controlCar(){
        ElevatorSystem.INSTANCE.getElevatorControlStrategy().controlElevator(elevatorControllerId);
        elevatorCar.setState(State.MOVING);
        System.out.println("Elevator is moving");
    }

    public int getElevatorControllerId() {
        return elevatorControllerId;
    }

    public void setElevatorControllerId(int elevatorControllerId) {
        this.elevatorControllerId = elevatorControllerId;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public List<Request> getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(List<Request> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }
}
