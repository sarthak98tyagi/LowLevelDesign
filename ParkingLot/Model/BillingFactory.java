package ParkingLot.Model;

public class BillingFactory {

    public BillingStrategy getBillingStrategy(String type){
        return switch (type){
            case "Hourly" -> new HourlyBillingStrategy();
            case "Minute" -> new MinuteBillingStrategy();
            default -> new BillingStrategy();
        };
    }
}
