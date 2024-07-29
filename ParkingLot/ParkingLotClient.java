package ParkingLot;

import ParkingLot.Model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotClient {

    public static void main(String[] args) {
        Vehicle twoWheelerVehicle = new Vehicle("UP12AJ3512", VehicleType.TWO_WHEELER);
        Vehicle fourWheelerVehicle = new Vehicle("UP12BZ3599", VehicleType.FOUR_WHEELER);
        List<Vehicle> vehicleList = List.of(twoWheelerVehicle,fourWheelerVehicle);
        ParkingSpotManagerFactory parkingSpotManagerFactory = new ParkingSpotManagerFactory();
        buildParkingLot(parkingSpotManagerFactory.getParkingSpotManager(VehicleType.FOUR_WHEELER),50);
        buildParkingLot(parkingSpotManagerFactory.getParkingSpotManager(VehicleType.TWO_WHEELER),25);
        EntranceGate entranceGate = new EntranceGate(parkingSpotManagerFactory);
        List<Ticket> ticketList = new ArrayList<>();
        for(Vehicle vehicle: vehicleList) {
            ParkingSpot parkingSpot = entranceGate.findParkingSpot(vehicle);
            if (parkingSpot != null) {
                Ticket ticket = entranceGate.bookParkingSpot(vehicle, parkingSpot);
                ticketList.add(ticket);
                System.out.println("Vehicle " + vehicle.getVehicleNumber() + " parked at slot " + ticket.getParkingSpot().getSlotNumber());
            } else {
                System.out.println("Wait, come after some time");
            }
        }
        BillingStrategy billingStrategy = new HourlyBillingStrategy();
        TwoWheelerParkingCostCalculator twoWheelerParkingCostCalculator = new TwoWheelerParkingCostCalculator(billingStrategy);
        FourWheelerParkingCostCalculator fourWheelerParkingCostCalculator = new FourWheelerParkingCostCalculator(billingStrategy);
        ExitGate exitGate = new ExitGate(parkingSpotManagerFactory);
        PaymentMode debitCardPaymentMode = new DebitCardPayment();
        for(Ticket ticket: ticketList){
            if(ticket.getVehicle().getVehicleType()==VehicleType.FOUR_WHEELER){
                exitGate.setCostCalculator(fourWheelerParkingCostCalculator);
            }
            else{
                exitGate.setCostCalculator(twoWheelerParkingCostCalculator);
            }

            Double totalBill = exitGate.calculateParkingCharges(ticket);
            System.out.println("Please pay parking charges "+totalBill);
            exitGate.setPaymentMode(debitCardPaymentMode);
            exitGate.payCharges(totalBill);
            exitGate.freeSpot(ticket);
        }
    }

    private static void buildParkingLot(ParkingSpotManager parkingSpotManager, int capacity) {
        for(int i=0;i<capacity;i++){
            parkingSpotManager.addParkingSlot();
        }
    }

}
