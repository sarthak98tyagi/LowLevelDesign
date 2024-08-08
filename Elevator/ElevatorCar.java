package Elevator;

public class ElevatorCar {

    private int elevatorId;

    private int currentFloor;

    private Direction direction;

    private State state;

    private InternalButton internalButton;

    private Door door;

    public ElevatorCar(int elevatorId){
        this.elevatorId = elevatorId;
        currentFloor = 0;
        direction = Direction.UP;
        state = State.IDEAL;
        internalButton = new InternalButton();
        door = new Door();
    }

    public void move(int floor, Direction direction){
        System.out.println("Elevator "+elevatorId+" moving to floor "+currentFloor);
        System.out.println("Stopping "+elevatorId+" at floor "+currentFloor);
    }

    public void pressButton(int floor){
        System.out.println("Button pressed in elevator "+elevatorId+" for floor "+floor+" towards "+direction);
        internalButton.pressButton(floor,direction,elevatorId);
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public void setInternalButton(InternalButton internalButton) {
        this.internalButton = internalButton;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

}
