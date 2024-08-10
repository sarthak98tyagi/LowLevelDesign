package VehicleRental;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Store {

    private String storeId;
    private String storeName;
    private Location location;
    private VehicleInventory vehicleInventory;
    private List<Booking> bookingList;

    public Store(String storeName, Location location, VehicleInventory vehicleInventory) {
        this.storeId = UUID.randomUUID().toString();
        this.storeName = storeName;
        this.location = location;
        this.vehicleInventory = vehicleInventory;
        bookingList = new ArrayList<>();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public List<Vehicle> showAvailableVehicles(VehicleType vehicleType){
        return vehicleInventory.showAvailableVehicles(vehicleType);
    }

    public void addBooking(Booking booking){
        booking.getVehicle().setBooked(true);
        System.out.println("Booking Scheduled "+booking.getBookingId());
        bookingList.add(booking);
    }

    public void removeBooking(Booking booking){
        for (Booking value : bookingList) {
            if (value.getBookingId().equals(booking.getBookingId())) {
                booking.getVehicle().setBooked(false);
                value.setBookingStatus(BookingStatus.COMPLETED);
                System.out.println("Booking completed " + booking.getBookingId());
                return;
            }
        }
    }

}
