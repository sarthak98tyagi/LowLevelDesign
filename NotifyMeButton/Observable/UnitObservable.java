package NotifyMeButton.Observable;

import NotifyMeButton.Observer.NotifyObserver;

public interface UnitObservable {
    void add(NotifyObserver observer);
    void remove(NotifyObserver observer);
    void notifyObservers();
    void setUnits(int units);
    int getUnits();
}
