package ParkingLot.Model;

public class ParkingSpot {
    private int slotNumber;
    private boolean isEmpty;
    private Vehicle vehicle;

    public ParkingSpot(int slotNumber) {
        this.slotNumber = slotNumber;
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.isEmpty=false;
        this.vehicle = vehicle;
    }

    public void freeSpot(){
        this.vehicle=null;
        this.isEmpty=true;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

}
