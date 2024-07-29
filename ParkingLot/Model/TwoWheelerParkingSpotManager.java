package ParkingLot.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {

    private List<ParkingSpot> parkingSpotList;

    private static TwoWheelerParkingSpotManager twoWheelerParkingSpotManager;

    private TwoWheelerParkingSpotManager(){
        parkingSpotList = new ArrayList<>();
    }

    public static TwoWheelerParkingSpotManager getInstance(){
        if(twoWheelerParkingSpotManager==null){
            synchronized (TwoWheelerParkingSpotManager.class){
                if(twoWheelerParkingSpotManager==null){
                    twoWheelerParkingSpotManager = new TwoWheelerParkingSpotManager();
                }
            }
        }
        return twoWheelerParkingSpotManager;
    }


    @Override
    public void addParkingSlot() {
        synchronized (TwoWheelerParkingSpotManager.class){
            ParkingSpot parkingSpot = new ParkingSpot(parkingSpotList.size()+1);
            parkingSpotList.add(parkingSpot);
            System.out.println("Added parking slot "+parkingSpot.getSlotNumber());
        }
    }

    @Override
    public ParkingSpot findParkingSpot() {
        synchronized (TwoWheelerParkingSpotManager.class){
            for(ParkingSpot spot: parkingSpotList) {
                if (spot.isEmpty())
                    return spot;
            }
            return null;
        }
    }

    @Override
    public Ticket bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        synchronized (TwoWheelerParkingSpotManager.class){
            parkingSpot.setEmpty(false);
            Ticket generatedTicket = new Ticket(parkingSpot,vehicle);
            System.out.println("Ticket booked at "+generatedTicket.getArrivalTime()+" Id:"+generatedTicket.getTicketId());
            return generatedTicket;
        }
    }

    @Override
    public void freeParkingSpot(ParkingSpot parkingSpot) {
        //free parking lot
        parkingSpot.setEmpty(true);
        System.out.println("Parking Spot "+parkingSpot.getSlotNumber()+" is empty");
    }
}
