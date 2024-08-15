package BookMyShow;

import java.util.List;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private User user;
    private Show show;
    private List<Seat> bookedTickets;
    private PaymentMode paymentMode;
    private Double bookingCharge;

    public Booking(User user, Show show, PaymentMode paymentMode,List<Seat> bookedTickets) {
        this.bookingId = UUID.randomUUID().toString();
        this.user = user;
        this.show = show;
        this.paymentMode = paymentMode;
        this.bookedTickets = bookedTickets;
        calculateBookingCharges();
    }

    private void calculateBookingCharges() {
        double totalPrice = 0;
        for (Seat seat: bookedTickets){
            totalPrice += seat.getPrice();
        }
        totalPrice = totalPrice + (0.1*totalPrice);
        bookingCharge = totalPrice;
        System.out.println("Booking: "+bookingId
                +"\nMovie Name: "+show.getMovie().getName()
                +"\nTicket Count: "+bookedTickets.size()
                +"\ncharges "+bookingCharge);
    }

    public void pay(){
        paymentMode.processPayment(bookingCharge);
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
