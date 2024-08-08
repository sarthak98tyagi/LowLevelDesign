package Elevator;

import java.util.List;

public class Building {

    List<Floor> floorList;

    List<ElevatorController> elevatorControllerList;

    public Building(List<Floor> floorList, List<ElevatorController> elevatorControllerList){
        this.floorList = floorList;
        this.elevatorControllerList = elevatorControllerList;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }
}
