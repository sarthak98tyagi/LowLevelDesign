package NotifyMeButton.Observer;

import NotifyMeButton.Observable.UnitObservable;

public class SmsNotifyObserver implements NotifyObserver {

    private UnitObservable stockUnitObservable;

    public SmsNotifyObserver(UnitObservable stockUnitObservable) {
        this.stockUnitObservable = stockUnitObservable;
    }

    @Override
    public void update() {
        System.out.println("Sms update stock units: "+stockUnitObservable.getUnits());
    }
}
