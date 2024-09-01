package Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    private List<Player> playingEleven;
    private List<Player> bench;
    private BattingController battingController;
    private BowlingController bowlingController;
    private Player captain;
    private List<Player> bowlers;
    private boolean isWinner;

    public Team(String teamName, List<Player> playingEleven, List<Player> bowlers, Player captain) {
        this.teamName = teamName;
        this.playingEleven = playingEleven;
        this.bench = new ArrayList<>();
        this.battingController = new BattingController(playingEleven);
        this.bowlingController = new BowlingController(bowlers);
        this.captain = captain;
    }

    public void printBattingScoreCard(){
        for(Player player : playingEleven){
            player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){

        for(Player playerDetails : playingEleven){
            if(playerDetails.getBowlingStats().getOversBowled() > 0) {
                playerDetails.printBowlingScoreCard();
            }
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayingEleven() {
        return playingEleven;
    }

    public void setPlayingEleven(List<Player> playingEleven) {
        this.playingEleven = playingEleven;
    }

    public List<Player> getBench() {
        return bench;
    }

    public void setBench(List<Player> bench) {
        this.bench = bench;
    }

    public BattingController getBattingController() {
        return battingController;
    }

    public void setBattingController(BattingController battingController) {
        this.battingController = battingController;
    }

    public BowlingController getBowlingController() {
        return bowlingController;
    }

    public void setBowlingController(BowlingController bowlingController) {
        this.bowlingController = bowlingController;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public int getTotalRuns(){
        int runs = 0;
        for(Player player: playingEleven){
            runs+=player.getBattingStats().getRunsScored();
        }
        return runs;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
