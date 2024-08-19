package ATM;

import ATM.State.IdleState;
import ATM.State.State;

public class Atm {
    private long amount;
    private Card card;
    private State state;
    private long twoThousandCount;
    private long fiveHundredCount;
    private long hundredCount;

    public Atm(long amount, long twoThousandCount,  long fiveHundredCount, long hundredCount) {
        this.twoThousandCount = twoThousandCount;
        this.amount = amount;
        this.fiveHundredCount = fiveHundredCount;
        this.hundredCount = hundredCount;
        this.state = new IdleState();
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public long getTwoThousandCount() {
        return twoThousandCount;
    }

    public void setTwoThousandCount(long twoThousandCount) {
        this.twoThousandCount = twoThousandCount;
    }

    public long getFiveHundredCount() {
        return fiveHundredCount;
    }

    public void setFiveHundredCount(long fiveHundredCount) {
        this.fiveHundredCount = fiveHundredCount;
    }

    public long getHundredCount() {
        return hundredCount;
    }

    public void setHundredCount(long hundredCount) {
        this.hundredCount = hundredCount;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
