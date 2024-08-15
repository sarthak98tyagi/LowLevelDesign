package BookMyShow;

public class CreditCardPayment implements PaymentMode {

    @Override
    public void processPayment(Double bill) {
        //execute Payment using Credit Card Details
        System.out.println("Credit Card Payment Initiated");
        System.out.println("Bill paid, Total "+bill);
    }

}
