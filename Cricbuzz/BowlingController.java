package Cricbuzz;

import java.util.*;

public class BowlingController {
    private Player currentBowler;
    private Map<Player,Integer> overCount;
    private Queue<Player> bowlersList;

    public BowlingController(List<Player> bowlers){
        overCount = new HashMap<>();
        this.bowlersList = new LinkedList<>(bowlers);
        for(Player bowler: bowlers){
            overCount.put(bowler,0);
        }
    }

    public void getNextBowler(int maxCount){
        while(!bowlersList.isEmpty()){
            Player bowler = bowlersList.poll();
            if(overCount.get(bowler)<maxCount){
                currentBowler = bowler;
                if(overCount.get(bowler)+1!=maxCount){
                    overCount.put(bowler,overCount.get(bowler)+1);
                }
                break;
            }
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }

    public Map<Player, Integer> getOverCount() {
        return overCount;
    }

    public void setOverCount(Map<Player, Integer> overCount) {
        this.overCount = overCount;
    }

    public Queue<Player> getBowlersList() {
        return bowlersList;
    }

    public void setBowlersList(Queue<Player> bowlersList) {
        this.bowlersList = bowlersList;
    }
}
