package VehicleRental;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private Vehicle vehicle;
    private User user;
    private BookingType bookingType;
    private long duration;
    private LocalDateTime bookingStartDateTime;
    private LocalDateTime expectedBookingEndDateTime;
    private LocalDateTime actualBookingEndDateTime;
    private BookingStatus bookingStatus;

    public Booking(Vehicle vehicle, User user, BookingType bookingType, long duration) {
        bookingId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.user = user;
        this.bookingType = bookingType;
        this.duration = duration;
        bookingStartDateTime = LocalDateTime.now();
        bookingStatus = BookingStatus.SCHEDULED;
        if(bookingType==BookingType.HOURLY){
            expectedBookingEndDateTime = bookingStartDateTime.plusHours(duration);
        }
        else if(bookingType==BookingType.DAY){
            expectedBookingEndDateTime = bookingStartDateTime.plusDays(duration);
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public LocalDateTime getBookingStartDateTime() {
        return bookingStartDateTime;
    }

    public void setBookingStartDateTime(LocalDateTime bookingStartDateTime) {
        this.bookingStartDateTime = bookingStartDateTime;
    }

    public LocalDateTime getExpectedBookingEndDateTime() {
        return expectedBookingEndDateTime;
    }

    public void setExpectedBookingEndDateTime(LocalDateTime expectedBookingEndDateTime) {
        this.expectedBookingEndDateTime = expectedBookingEndDateTime;
    }

    public LocalDateTime getActualBookingEndDateTime() {
        return actualBookingEndDateTime;
    }

    public void setActualBookingEndDateTime(LocalDateTime actualBookingEndDateTime) {
        this.actualBookingEndDateTime = actualBookingEndDateTime;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
