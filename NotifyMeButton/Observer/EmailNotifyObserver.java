package NotifyMeButton.Observer;

import NotifyMeButton.Observable.UnitObservable;

public class EmailNotifyObserver implements NotifyObserver{

    private UnitObservable stockUnitObservable;

    public EmailNotifyObserver(UnitObservable stockUnitObservable) {
        this.stockUnitObservable = stockUnitObservable;
    }

    @Override
    public void update() {
        System.out.println("Email update stock units: "+stockUnitObservable.getUnits());

    }
}
