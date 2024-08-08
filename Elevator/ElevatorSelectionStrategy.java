package Elevator;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorSelectionStrategy {

    public abstract int selectElevator(int floor, Direction direction);

}
