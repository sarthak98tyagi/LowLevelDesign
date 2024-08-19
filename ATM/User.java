package ATM;

public class User {

    private String name;
    private Card card;
    private BankAccount bankAccount;

    public User(String name, Card card, BankAccount bankAccount) {
        this.name = name;
        this.card = card;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
