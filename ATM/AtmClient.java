package ATM;

import java.util.UUID;

public class AtmClient {

    public static void main(String[] args) {
        Atm atm = new Atm(200000,50,1000, 5000);
        User user = createUser();

        atm.getState().insertCard(atm,user.getCard());
        boolean validated = atm.getState().authenticatePin(atm,1234);
        if(validated) {
//            atm.getState().selectTransaction(atm, TransactionType.BALANCE_ENQUIRY);
//            atm.getState().enquiryBalance(atm);
//            atm.getState().selectTransaction(atm,TransactionType.CHANGE_PIN);
//            atm.getState().changePin(atm,5431);
            atm.getState().selectTransaction(atm,TransactionType.WITHDRAW);
            atm.getState().withdrawAmount(atm,8900);
        }
    }

    private static User createUser() {
        BankAccount bankAccount = new BankAccount(UUID.randomUUID().toString(),"Sarthak",100000000L);
        Card card = new Card(UUID.randomUUID().toString(),"Sarthak",899,12,2032,bankAccount,1234);
        User user = new User("Sarthak",card,bankAccount);
        return user;
    }
}
