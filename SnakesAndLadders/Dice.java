package SnakesAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int roll(){
        int countSum = 0, rollCount = 0;
        while(rollCount<numberOfDice){
            countSum+= ThreadLocalRandom.current().nextInt(1,7);
            rollCount++;
        }
        return countSum;
    }
}
