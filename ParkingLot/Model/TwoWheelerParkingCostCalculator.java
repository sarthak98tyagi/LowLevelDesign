package ParkingLot.Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TwoWheelerParkingCostCalculator extends CostCalculator{

    public TwoWheelerParkingCostCalculator(BillingStrategy billingStrategy) {
        super(billingStrategy);
    }

    @Override
    public Double calculateCost(Ticket ticket) {
        return billingStrategy.calculateBill(ticket)+15;
    }
}
