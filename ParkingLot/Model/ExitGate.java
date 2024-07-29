package ParkingLot.Model;

public class ExitGate {

    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private ParkingSpotManager parkingSpotManager;
    private CostCalculator costCalculator;
    private PaymentMode paymentMode;

    public ExitGate(ParkingSpotManagerFactory parkingSpotManagerFactory){
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
    }

    public Double calculateParkingCharges(Ticket ticket){
        return costCalculator.calculateCost(ticket);
    }

    public void payCharges(Double amount){
        paymentMode.processPayment(amount);
    }

    public void freeSpot(Ticket ticket){
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(ticket.getVehicle().getVehicleType());
        parkingSpotManager.freeParkingSpot(ticket.getParkingSpot());
    }

    public ParkingSpotManager getParkingSpotManager() {
        return parkingSpotManager;
    }

    public void setParkingSpotManager(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }

    public CostCalculator getCostCalculator() {
        return costCalculator;
    }

    public void setCostCalculator(CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
