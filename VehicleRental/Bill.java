package VehicleRental;

import java.time.Duration;

public class Bill {

    private Booking booking;

    private static final double HOURLY_BOOKING_RATE = 50;

    private static final double DAY_BOOKING_RATE = 250;

    private static final double TWO_RATE = 0;

    private static final double THREE_RATE = 1.25;

    private static final double FOUR_RATE = 1.5;

    private double bookingAmount;

    private double extraDelayAmount;

    private BillStatus billStatus;


    public Bill(Booking booking) {
        this.booking = booking;
        billStatus = BillStatus.PENDING;
    }

    public double calculateBill(){
        System.out.println("Calculation bill : "+booking.getBookingStatus());
        if(booking.getBookingStatus()==BookingStatus.SCHEDULED){
            return bookingAmount =  switch (booking.getVehicle().getVehicleType()){
                case TWO_WHEELER -> calculateRent(TWO_RATE, booking.getBookingType() , booking.getDuration());
                case FOUR_WHEELER -> calculateRent(FOUR_RATE, booking.getBookingType(), booking.getDuration());
                case THREE_WHEELER -> calculateRent(THREE_RATE, booking.getBookingType(), booking.getDuration());
            };
        }
        else if(booking.getBookingStatus()==BookingStatus.RETURN){
            Duration extraTime = Duration.between(booking.getExpectedBookingEndDateTime(), booking.getActualBookingEndDateTime());
            long duration = booking.getBookingType()==BookingType.HOURLY?extraTime.toHours():extraTime.toDays();
            return extraDelayAmount = switch (booking.getVehicle().getVehicleType()){
                case TWO_WHEELER -> calculateRent(TWO_RATE, booking.getBookingType() , duration);
                case FOUR_WHEELER -> calculateRent(FOUR_RATE, booking.getBookingType(), duration);
                case THREE_WHEELER -> calculateRent(THREE_RATE, booking.getBookingType(), duration);
            };
        }
        else
            return bookingAmount+extraDelayAmount;
    }

    private double calculateRent(double rate, BookingType type, long duration){
        double baseCharge = (type==BookingType.HOURLY)?HOURLY_BOOKING_RATE:DAY_BOOKING_RATE;
        double baseAmount = baseCharge * duration;
        return baseAmount + (baseAmount*rate);
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public double getExtraDelayAmount() {
        return extraDelayAmount;
    }

    public void setExtraDelayAmount(double extraDelayAmount) {
        this.extraDelayAmount = extraDelayAmount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
