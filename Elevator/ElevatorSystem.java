package Elevator;

import java.util.List;

public class ElevatorSystem {

    List<ElevatorController> elevatorControllerList;
    ElevatorControlStrategy elevatorControlStrategy;
    ElevatorSelectionStrategy elevatorSelectionStrategy;

    static ElevatorSystem INSTANCE = new ElevatorSystem();


    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }

    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy) {
        this.elevatorControlStrategy = elevatorControlStrategy;
    }

    public ElevatorSelectionStrategy getElevatorSelectionStrategy() {
        return elevatorSelectionStrategy;
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }
}
