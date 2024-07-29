package ParkingLot.Model;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {

    private List<ParkingSpot> parkingSpotList;

    private static FourWheelerParkingSpotManager fourWheelerParkingSpotManager;

    private FourWheelerParkingSpotManager(){
        parkingSpotList = new ArrayList<>();
    }

    public static FourWheelerParkingSpotManager getInstance(){
        if(fourWheelerParkingSpotManager==null){
            synchronized(FourWheelerParkingSpotManager.class){
                if(fourWheelerParkingSpotManager==null){
                    fourWheelerParkingSpotManager = new FourWheelerParkingSpotManager();
                }
            }
        }
        return fourWheelerParkingSpotManager;
    }

    @Override
    public void addParkingSlot() {
        synchronized (FourWheelerParkingSpotManager.class){
            ParkingSpot parkingSpot = new ParkingSpot(parkingSpotList.size()+1);
            parkingSpotList.add(parkingSpot);
            System.out.println("Added parking slot "+parkingSpot.getSlotNumber());
        }
    }

    @Override
    public ParkingSpot findParkingSpot() {
        synchronized (FourWheelerParkingSpotManager.class){
            for(ParkingSpot spot: parkingSpotList) {
                if (spot.isEmpty())
                    return spot;
            }
            return null;
        }
    }

    @Override
    public Ticket bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        synchronized (FourWheelerParkingSpotManager.class){
            parkingSpot.setEmpty(false);
            Ticket generatedTicket = new Ticket(parkingSpot,vehicle);
            System.out.println("Ticket booked at "+generatedTicket.getArrivalTime()+" Id:"+generatedTicket.getTicketId());
            return generatedTicket;
        }
    }

    @Override
    public void freeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setEmpty(true);
        System.out.println("Parking Spot "+parkingSpot.getSlotNumber()+" is empty");
    }
}
