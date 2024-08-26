package Splitwise.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> userList;

    public UserController(){
        userList = new ArrayList<>();
    }

    public UserController(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
