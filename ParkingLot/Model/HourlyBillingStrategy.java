package ParkingLot.Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyBillingStrategy extends BillingStrategy{

    @Override
    public Double calculateBill(Ticket ticket){
        long diff = ChronoUnit.MINUTES.between(LocalDateTime.now(),ticket.getArrivalTime());
        return (diff/60.0+1)*100;
    }
}
