package VehicleRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleInventory {

    private List<Vehicle> twoWheelerVehicleList;
    private List<Vehicle> fourWheelerVehicleList;
    private List<Vehicle> threeWheelerVehicleList;


    public VehicleInventory(){
        this.twoWheelerVehicleList = new ArrayList<>();
        this.fourWheelerVehicleList = new ArrayList<>();
        this.threeWheelerVehicleList = new ArrayList<>();
    }

    public List<Vehicle> getTwoWheelerVehicleList() {
        return twoWheelerVehicleList;
    }

    public void setTwoWheelerVehicleList(List<Vehicle> twoWheelerVehicleList) {
        this.twoWheelerVehicleList = twoWheelerVehicleList;
    }

    public List<Vehicle> getFourWheelerVehicleList() {
        return fourWheelerVehicleList;
    }

    public void setFourWheelerVehicleList(List<Vehicle> fourWheelerVehicleList) {
        this.fourWheelerVehicleList = fourWheelerVehicleList;
    }

    public List<Vehicle> getThreeWheelerVehicleList() {
        return threeWheelerVehicleList;
    }

    public void setThreeWheelerVehicleList(List<Vehicle> threeWheelerVehicleList) {
        this.threeWheelerVehicleList = threeWheelerVehicleList;
    }

    public void addVehicle(Vehicle vehicle){
        switch (vehicle.getVehicleType()){
            case TWO_WHEELER -> twoWheelerVehicleList.add(vehicle);
            case THREE_WHEELER -> threeWheelerVehicleList.add(vehicle);
            case FOUR_WHEELER -> fourWheelerVehicleList.add(vehicle);
        }
    }

    public Vehicle getVehicle(String vehicleNumber, VehicleType vehicleType){
        return switch (vehicleType){
            case TWO_WHEELER -> {
                Optional<Vehicle> optionalVehicle = twoWheelerVehicleList.stream().filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber)).findAny();
                yield optionalVehicle.orElse(null);
            }
            case THREE_WHEELER -> {
                Optional<Vehicle> optionalVehicle = threeWheelerVehicleList.stream().filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber)).findAny();
                yield optionalVehicle.orElse(null);
            }
            case FOUR_WHEELER -> {
                Optional<Vehicle> optionalVehicle = fourWheelerVehicleList.stream().filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber)).findAny();
                yield optionalVehicle.orElse(null);
            }
        };
    }

    public List<Vehicle> showAvailableVehicles(VehicleType vehicleType){
        return switch (vehicleType){
            case TWO_WHEELER -> twoWheelerVehicleList.stream().filter(vehicle -> !vehicle.isBooked() && vehicle.getVehicleStatus()!=VehicleStatus.INACTIVE).collect(Collectors.toList());
            case THREE_WHEELER ->  threeWheelerVehicleList.stream().filter(vehicle -> !vehicle.isBooked() && vehicle.getVehicleStatus()!=VehicleStatus.INACTIVE).collect(Collectors.toList());
            case FOUR_WHEELER ->   fourWheelerVehicleList.stream().filter(vehicle -> !vehicle.isBooked() && vehicle.getVehicleStatus()!=VehicleStatus.INACTIVE).collect(Collectors.toList());
        };
    }
}
