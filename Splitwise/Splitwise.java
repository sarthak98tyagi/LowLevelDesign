package Splitwise;

import Splitwise.BalanceSheet.BalanceSheet;
import Splitwise.BalanceSheet.BalanceSheetController;
import Splitwise.Expense.ExpenseController;
import Splitwise.Expense.Split.Split;
import Splitwise.Expense.Split.SplitType;
import Splitwise.Group.Group;
import Splitwise.Group.GroupController;
import Splitwise.User.User;
import Splitwise.User.UserController;

import java.util.HashMap;
import java.util.List;

public class Splitwise {

    UserController userController;
    GroupController groupController;

    public void setup(){
        userController = new UserController();
        groupController = new GroupController();
        ExpenseController expenseController = new ExpenseController(new BalanceSheetController());
        createUsers();
        Group group = createGroup(expenseController);
        List<Split> splitList = List.of(new Split(userController.getUserList().get(0),450,0),
                new Split(userController.getUserList().get(1),450,0),
                new Split(userController.getUserList().get(2),450,0),
            new Split(userController.getUserList().get(3),450,0));
        group.createExpense("Lunch@Taj", SplitType.UNIFORM_AMOUNT,splitList,group.getMemberList().get(0),1800);
        List<Split> splitListPercentage = List.of(new Split(userController.getUserList().get(0),0,25),
                new Split(userController.getUserList().get(1),0,25),
                new Split(userController.getUserList().get(2),0,25),
                new Split(userController.getUserList().get(3),0,25));
        group.createExpense("Dinner@Taj",SplitType.PERCENTAGE,splitListPercentage,group.getMemberList().get(0), 2000);
        List<Split> splitListNonUniform = List.of(new Split(userController.getUserList().get(0), 200,0),
                new Split(userController.getUserList().get(1), 800,0),
                new Split(userController.getUserList().get(2),0,0),
                new Split(userController.getUserList().get(3),600,0));
        group.createExpense("Breakfast@Taj",SplitType.NON_UNIFORM_AMOUNT,splitListNonUniform,group.getMemberList().get(1), 1600);
        for(User user: group.getMemberList()){
            user.displayBalanceSheet();
        }
    }

    private Group createGroup(ExpenseController expenseController) {
        Group group = groupController.createGroup("Lunch Buddy",userController.getUserList(),expenseController);
        return group;
    }

    private void createUsers() {
        userController.addUser(new User("Sarthak",new BalanceSheet(new HashMap<>(),0,0,0,0)));
        userController.addUser(new User("Alex",new BalanceSheet(new HashMap<>(),0,0,0,0)));
        userController.addUser(new User("John",new BalanceSheet(new HashMap<>(),0,0,0,0)));
        userController.addUser(new User("Mike",new BalanceSheet(new HashMap<>(),0,0,0,0)));
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public GroupController getGroupController() {
        return groupController;
    }

    public void setGroupController(GroupController groupController) {
        this.groupController = groupController;
    }

}
