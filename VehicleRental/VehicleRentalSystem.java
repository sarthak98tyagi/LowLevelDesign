package VehicleRental;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRentalSystem {

    List<Store> storeList;
    List<User> userList;

    public VehicleRentalSystem(){
        this.storeList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public VehicleRentalSystem(List<Store> storeList, List<User> userList){
        this.storeList  = storeList;
        this.userList = userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void addStore(Store store){
        storeList.add(store);
    }

    public List<Store> getStoreList(String pincode){
        return storeList.stream().filter( store -> store.getLocation().getPincode().equals(pincode)).collect(Collectors.toList());
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
