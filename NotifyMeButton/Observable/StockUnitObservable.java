package NotifyMeButton.Observable;

import NotifyMeButton.Observer.NotifyObserver;
import java.util.*;

public class StockUnitObservable implements UnitObservable{

    private List<NotifyObserver> observerList;

    private int stockUnits;

    public StockUnitObservable() {
        observerList = new ArrayList<>();
        stockUnits = 0;
    }

    @Override
    public void add(NotifyObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotifyObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotifyObserver observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setUnits(int units) {
        this.stockUnits = Math.max(units, 0);
        notifyObservers();
    }

    @Override
    public int getUnits() {
        return stockUnits;
    }
}
