package ParkingLot.Model;

public abstract class CostCalculator {

    protected BillingStrategy billingStrategy;

    public CostCalculator(BillingStrategy billingStrategy){
        this.billingStrategy=billingStrategy;
    }

    public abstract Double calculateCost(Ticket ticket);

}
