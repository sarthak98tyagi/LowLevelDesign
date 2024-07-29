package ParkingLot.Model;

public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType){
        switch (vehicleType){
            case TWO_WHEELER -> {
                return TwoWheelerParkingSpotManager.getInstance();
            }
            case FOUR_WHEELER -> {
                return FourWheelerParkingSpotManager.getInstance();
            }
            default -> {
                return null;
            }
        }
    }
}
