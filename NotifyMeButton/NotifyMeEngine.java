package NotifyMeButton;

import NotifyMeButton.Observable.StockUnitObservable;
import NotifyMeButton.Observable.UnitObservable;
import NotifyMeButton.Observer.EmailNotifyObserver;
import NotifyMeButton.Observer.NotifyObserver;
import NotifyMeButton.Observer.SmsNotifyObserver;
import NotifyMeButton.Observer.WhatsAppNotifyObserver;

import java.util.Scanner;

public class NotifyMeEngine {

    public static void main(String[] args){

        UnitObservable stockUnitObservable = new StockUnitObservable();
        NotifyObserver emailNotifyServer = new EmailNotifyObserver(stockUnitObservable);
        NotifyObserver smsNotifyServer = new SmsNotifyObserver(stockUnitObservable);
        NotifyObserver whatsAppNotifyObserver = new WhatsAppNotifyObserver(stockUnitObservable);
        stockUnitObservable.add(emailNotifyServer);
        stockUnitObservable.add(smsNotifyServer);
        stockUnitObservable.add(whatsAppNotifyObserver);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter units in stock");
        int units = sc.nextInt();
        stockUnitObservable.setUnits(units);
    }
}
