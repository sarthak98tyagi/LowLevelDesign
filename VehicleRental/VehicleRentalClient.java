package VehicleRental;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentalClient {

    public static void main(String[] args) {

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();

        List<User> userList = new ArrayList<>();
        User user1 = new User("Alex",25,"alex@yahoo.com","9989899891","SADADAD656");
        User user2 = new User("John",20,"john@yahoo.com","8965981278","ASSASASSSS");
        userList.add(user1);
        userList.add(user2);
        vehicleRentalSystem.setUserList(userList);

        List<Location> locationList = new ArrayList<>();
        Location location1 = new Location("XY Street","Delhi", "Delhi,","1234","India");
        Location location2 = new Location("XZ Street", "Bengaluru", "Karnataka","5678","India");
        locationList.add(location1);
        locationList.add(location2);

        //Add Stores
        VehicleInventory store1VehicleInventory = new VehicleInventory();
        store1VehicleInventory.addVehicle(new Vehicle("DL12AC5656","KIA","CELTOS",VehicleType.FOUR_WHEELER,VehicleStatus.ACTIVE,EngineType.DIESEL));
        store1VehicleInventory.addVehicle(new Vehicle("DL14BC5566","Honda","ACTIVA",VehicleType.TWO_WHEELER,VehicleStatus.ACTIVE,EngineType.PETROL));
        List<Store> storeList = new ArrayList<>();
        Store store1 = new Store("Store A",location1,store1VehicleInventory);

        VehicleInventory store2VehicleInventory = new VehicleInventory();
        store2VehicleInventory.addVehicle(new Vehicle("DL12AC4566","Tata","Harrier",VehicleType.FOUR_WHEELER,VehicleStatus.ACTIVE,EngineType.DIESEL));
        store2VehicleInventory.addVehicle(new Vehicle("DL14BC8996","Royal","Enfield",VehicleType.TWO_WHEELER,VehicleStatus.ACTIVE,EngineType.PETROL));
        Store store2 = new Store("Store B",location2, store2VehicleInventory);
        storeList.add(store1);
        storeList.add(store2);

        vehicleRentalSystem.setStoreList(storeList);

        //Show available Vehicles
        Store store = vehicleRentalSystem.getStoreList(location1.getPincode()).getFirst();
        System.out.println("Available Vehicles: ");
        List<Vehicle> availableVehicles = store.showAvailableVehicles(VehicleType.FOUR_WHEELER);

        if(availableVehicles==null || availableVehicles.isEmpty()){
            System.out.println("Currently vehicle is not available");
        }
        else{
            availableVehicles.stream().forEach(vehicle -> System.out.println(vehicle.toString()));
            Vehicle vehicle = availableVehicles.getFirst();
            Booking booking = new Booking(vehicle,user1,BookingType.HOURLY,2);
            store.addBooking(booking);
            Bill bill = new Bill(booking);
            Payment payment = new Payment(bill,new CreditCardPayment());
            payment.payBookingCharges();
            System.out.println("Booking Charges Paid");
            //Vehicle return
            booking.setBookingStatus(BookingStatus.RETURN);
            LocalDateTime currentTime = LocalDateTime.now().plusHours(4);
            booking.setActualBookingEndDateTime(currentTime);
            if(booking.getExpectedBookingEndDateTime().compareTo(currentTime)<0){
                payment.payDelayCharges();
            }
            else{
                bill.setBillStatus(BillStatus.COMPLETE);
            }
            store.removeBooking(booking);
            System.out.println("Bill Status "+bill.getBillStatus()+" Total Bill "+(bill.getBookingAmount()+bill.getExtraDelayAmount()));

        }




    }

}
