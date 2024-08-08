package Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorClient {

    public static void main(String[] args) {

        //Create floors, elevator and elevator controller
        List<Floor> floorList = new ArrayList<>();
        for(int i=0;i<11;i++){
            floorList.add(new Floor(i));
        }

        List<ElevatorController> elevatorControllerList = new ArrayList<>();
        for(int i=0;i<4;i++){
            ElevatorCar elevatorCar = new ElevatorCar(i);
            ElevatorController elevatorController = new ElevatorController(elevatorCar);
            elevatorControllerList.add(elevatorController);
        }

        ElevatorSystem elevatorSystem = ElevatorSystem.INSTANCE;
        elevatorSystem.setElevatorControlStrategy(new LookStrategy());
        elevatorSystem.setElevatorSelectionStrategy(new OddEvenStrategy());
        elevatorSystem.setElevatorControllerList(elevatorControllerList);
        Building building = new Building(floorList,elevatorControllerList);

        System.out.println("User at floor 1 presses UP Button");
        for(Floor floor: building.getFloorList())
        {
            if(floor.getFloor()==1)
                floor.pressButton(Direction.UP);
        }

        System.out.println("User at floor 5 presses UP Button");
        for(Floor floor: building.getFloorList())
        {
            if(floor.getFloor()==5)
                floor.pressButton(Direction.UP);
        }

        System.out.println("User presses 10 in elevator 2");
        for(ElevatorController elevatorController: ElevatorSystem.INSTANCE.getElevatorControllerList())
        {
            if(elevatorController.getElevatorControllerId()==2)
                elevatorController.getElevatorCar().pressButton(10);

        }

        System.out.println("User presses 6 in elevator 2");
        for(ElevatorController elevatorController: ElevatorSystem.INSTANCE.getElevatorControllerList())
        {
            if(elevatorController.getElevatorControllerId()==2)
                elevatorController.getElevatorCar().pressButton(6);
        }

        System.out.println("User at floor 7 presses DOWN Button");
        for(Floor floor: building.getFloorList())
        {
            if(floor.getFloor()==7)
                floor.pressButton(Direction.DOWN);
        }

    }
}
