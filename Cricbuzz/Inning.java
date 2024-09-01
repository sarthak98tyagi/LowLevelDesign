package Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Inning {

    private Team battingTeam;
    private Team bowlingTeam;
    private MatchFormat matchFormat;
    private List<Over> overs;

    public Inning(){}

    public Inning(Team battingTeam, Team bowlingTeam, MatchFormat matchFormat) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchFormat = matchFormat;
        overs = new ArrayList<>();
    }

    public void start(int runsToWin){

        battingTeam.getBattingController().getNextPlayer();
        int noOfOvers = matchFormat.getOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {

            bowlingTeam.getBowlingController().getNextBowler(matchFormat.getPerBowlerOver());
            Over over = new Over(bowlingTeam.getBowlingController().getCurrentBowler(), overNumber);
            overs.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won == true) {
                    break;
                }
            }catch (Exception e) {
                break;
            }

            Player temp = battingTeam.getBattingController().getStriker();
            battingTeam.getBattingController().setStriker(battingTeam.getBattingController().getNonStriker());
            battingTeam.getBattingController().setNonStriker(temp);
        }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }


    public MatchFormat getMatchFormat() {
        return matchFormat;
    }

    public void setMatchFormat(MatchFormat matchFormat) {
        this.matchFormat = matchFormat;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }

}
