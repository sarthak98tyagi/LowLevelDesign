package NotifyMeButton.Observer;

import NotifyMeButton.Observable.UnitObservable;

public class WhatsAppNotifyObserver implements NotifyObserver {

    private UnitObservable stockUnitObservable;

    public WhatsAppNotifyObserver(UnitObservable stockUnitObservable) {
        this.stockUnitObservable = stockUnitObservable;
    }

    @Override
    public void update() {
        System.out.println("Whatsapp update stock units: "+stockUnitObservable.getUnits());
    }
}
