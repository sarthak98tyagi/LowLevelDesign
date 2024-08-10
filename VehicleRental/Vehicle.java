package VehicleRental;

public class Vehicle {

    private String vehicleNumber;
    private String brand;
    private String modelName;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private long kmDriven;
    private EngineType engineType;
    private boolean isBooked;

    public Vehicle(String vehicleNumber, String brand, String modelName, VehicleType vehicleType, VehicleStatus vehicleStatus, EngineType engineType) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.modelName = modelName;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
        this.kmDriven = 0;
        this.engineType = engineType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public long getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(long kmDriven) {
        this.kmDriven = kmDriven;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", vehicleType=" + vehicleType +
                ", vehicleStatus=" + vehicleStatus +
                ", kmDriven=" + kmDriven +
                ", engineType=" + engineType +
                ", isBooked=" + isBooked +
                '}';
    }
}
