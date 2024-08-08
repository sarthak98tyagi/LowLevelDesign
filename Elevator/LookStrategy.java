package Elevator;

public class LookStrategy extends ElevatorControlStrategy{

    @Override
    public void controlElevator(int elevatorID) {
        //Use Look Algorithm which does not go to extreme end in one direction, just got to last pending request floor in a particular direction and take turn
        //Look algo can be implemented using two priority queue
    }
}
