package Splitwise.Group;

import Splitwise.Expense.ExpenseController;
import Splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    private List<Group> groupList;

    public GroupController(){
        groupList = new ArrayList<>();
    }

    public GroupController(List<Group> groupList) {
        this.groupList = groupList;
    }

    public void addGroup(Group group){
        groupList.add(group);
    }

    public Group createGroup(String groupName, List<User> memberList, ExpenseController expenseController){
        Group group = new Group(groupName,memberList,new ArrayList<>(),expenseController);
        groupList.add(group);
        return group;
    }

    public Group getGroup(String groupId){
        for(Group group: groupList){
            if(group.getGroupId().equals(groupId))
                return group;
        }
        return null;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

}
