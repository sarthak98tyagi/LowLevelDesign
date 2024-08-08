package Elevator;

import java.util.concurrent.ThreadLocalRandom;

public class OddEvenStrategy extends ElevatorSelectionStrategy {

    @Override
    public int selectElevator(int floor, Direction direction) {
        for(ElevatorController controller: ElevatorSystem.INSTANCE.getElevatorControllerList()){
            if(controller.getElevatorControllerId()%2==floor%2){
                if(controller.getElevatorCar().getState() ==State.IDEAL){
                    return controller.getElevatorControllerId();
                }
                else if(controller.getElevatorCar().getDirection() == direction &&
                        direction==Direction.UP && controller.getElevatorCar().getCurrentFloor()<=floor){
                       return controller.getElevatorControllerId();
                }
                else if(controller.getElevatorCar().getDirection() == direction &&
                        direction==Direction.DOWN && controller.getElevatorCar().getCurrentFloor()>=floor){
                    return controller.getElevatorControllerId();
                }
            }
        }
        return ThreadLocalRandom.current().nextInt(0,ElevatorSystem.INSTANCE.getElevatorControllerList().size()-1);
    }
}
