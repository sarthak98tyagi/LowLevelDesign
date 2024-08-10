package VehicleRental;

public class DebitCardPayment implements PaymentMode {
    @Override
    public void processPayment(Double bill) {
        //execute Payment using UPI gateway
        System.out.println("Debit Card Payment Initiated");
        System.out.println("Payment Completed, Total "+bill);
    }
}
