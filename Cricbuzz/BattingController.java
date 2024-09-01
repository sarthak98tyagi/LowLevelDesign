package Cricbuzz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BattingController {
    private Queue<Player> yetToPlay;
    private Player striker;
    private Player nonStriker;

    public BattingController(List<Player> players){
        yetToPlay = new LinkedList<>();
        yetToPlay.addAll(players);
    }

    public void getNextPlayer(){
        if(yetToPlay.isEmpty()){
            return;
        }
        if(striker==null){
            striker = yetToPlay.poll();
        }
        if(nonStriker==null){
            nonStriker = yetToPlay.poll();
        }
    }

    public Queue<Player> getYetToPlay() {
        return yetToPlay;
    }

    public void setYetToPlay(Queue<Player> yetToPlay) {
        this.yetToPlay = yetToPlay;
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
        if(striker==null)
            getNextPlayer();
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
        if(nonStriker==null)
            getNextPlayer();
    }
}
