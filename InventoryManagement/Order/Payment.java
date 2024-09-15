package InventoryManagement.Order;

public class Payment {

    private PaymentMode paymentMode;

    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean pay(double amount){
        try{
            paymentMode.processPayment(amount);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
