package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private Inventory inventory;
    private State state;
    private long totalMoney;
    private long lastAmountAdded;
    private List<Money> addedMoney;
    private List<CurrencyMap> currencyMap;

    public VendingMachine(Inventory inventory, State state) {
        this.inventory = inventory;
        this.state = state;
        totalMoney = 0;
        lastAmountAdded = 0;
        currencyMap = new ArrayList<>();
        addedMoney = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<CurrencyMap> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(List<CurrencyMap> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public long getLastAmountAdded() {
        return lastAmountAdded;
    }

    public void setLastAmountAdded(long lastAmountAdded) {
        this.lastAmountAdded = lastAmountAdded;
    }

    public List<Money> getAddedMoney() {
        return addedMoney;
    }

    public void setAddedMoney(List<Money> addedMoney) {
        this.addedMoney = addedMoney;
    }

}
