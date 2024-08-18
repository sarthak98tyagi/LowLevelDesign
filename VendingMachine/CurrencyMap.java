package VendingMachine;

public class CurrencyMap {
    private Money currency;
    private int count;

    public CurrencyMap(Money currency, int count) {
        this.currency = currency;
        this.count = count;
    }

    public Money getCurrency() {
        return currency;
    }

    public void setCurrency(Money currency) {
        this.currency = currency;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
