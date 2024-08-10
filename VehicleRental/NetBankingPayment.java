package VehicleRental;

public class NetBankingPayment implements PaymentMode {
    @Override
    public void processPayment(Double bill) {
        //execute Payment using UPI gateway
        System.out.println("Net Banking Payment Initiated");
        System.out.println("Payment Completed, Total "+bill);
    }
}
