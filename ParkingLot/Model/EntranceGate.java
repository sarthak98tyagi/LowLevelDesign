package ParkingLot.Model;

public class EntranceGate {

    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private ParkingSpotManager parkingSpotManager;

    public EntranceGate(ParkingSpotManagerFactory parkingSpotManagerFactory){
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle){
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
        return parkingSpotManager.findParkingSpot();
    }

    public Ticket bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot){
        try{
            parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
            return parkingSpotManager.bookParkingSpot(vehicle, parkingSpot);
        }
        catch(Exception e){
            //handle exception
        }
        return null;
    }

    public ParkingSpotManager getParkingSpotManager() {
        return parkingSpotManager;
    }

    public void setParkingSpotManager(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }
}
