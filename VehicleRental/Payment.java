package VehicleRental;

public class Payment {

    private Bill bill;

    private PaymentMode paymentMode;

    public Payment(Bill bill, PaymentMode paymentMode) {
        this.bill = bill;
        this.paymentMode = paymentMode;
    }

    public void payBookingCharges(){
        double amount = bill.calculateBill();
        System.out.println("Please pay partial booking charges "+amount);
        paymentMode.processPayment(amount);
        bill.setBillStatus(BillStatus.PARTIAL);

    }

    public void payDelayCharges(){
        double amount = bill.calculateBill();
        System.out.println("Please pay delay charges "+amount);
        paymentMode.processPayment(amount);
        bill.setBillStatus(BillStatus.COMPLETE);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
