package Splitwise.Group;

import Splitwise.Expense.Expense;
import Splitwise.Expense.ExpenseController;
import Splitwise.Expense.Split.Split;
import Splitwise.Expense.Split.SplitType;
import Splitwise.User.User;

import java.util.List;
import java.util.UUID;

public class Group {

    private String groupId;
    private String groupName;
    private List<User> memberList;
    private List<Expense> expensesList;
    private ExpenseController expenseController;

    public Group(String groupName, List<User> memberList, List<Expense> expensesList, ExpenseController expenseController) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.memberList = memberList;
        this.expensesList = expensesList;
        this.expenseController = expenseController;
    }

    public void createExpense(String title, SplitType splitType, List<Split> splits, User paidBy, double amount){
        Expense expense = expenseController.createExpense(title,splitType,splits,paidBy,amount);
        if(expense!=null)
            expensesList.add(expense);
    }

    public void addMember(User user){
        memberList.add(user);
    }

    public void addExpenses(Expense expense){
        expensesList.add(expense);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Expense> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expense> expensesList) {
        this.expensesList = expensesList;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public void setExpenseController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }

    public List<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<User> memberList) {
        this.memberList = memberList;
    }

}
