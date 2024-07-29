package ParkingLot.Model;

import java.util.List;

public abstract class ParkingSpotManager {

    public abstract void addParkingSlot();

    public abstract ParkingSpot findParkingSpot();

    public abstract Ticket bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot);

    public abstract void freeParkingSpot(ParkingSpot parkingSpot);
}
