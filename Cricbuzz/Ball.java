package Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    private int ballNo;
    private BallType ballType;
    private RunType runType;
    private int runsScored;
    private Wicket wicket;
    private Player bowledBy;
    private Player playedBy;
    private List<ScoreUpdateObserver> observerList;

    public Ball(){}

    public Ball(int ballNo) {
        this.ballNo = ballNo;
        observerList = new ArrayList<>();
        observerList.add(new BattingScoreUpdateObserver());
        observerList.add(new BowlingScoreUpdateObserver());
    }

    public void deliverBall(Team battingTeam, Team bowlingTeam, Over over){
        playedBy = battingTeam.getBattingController().getStriker();
        bowledBy = bowlingTeam.getBowlingController().getCurrentBowler();
        ballType = BallType.LEGAL;
        if (isWicketTaken()) {
            runType = RunType.DOT;
            wicket = new Wicket(WicketType.BOWLED, over,this);
        } else {
            runType = getRunTypeDetails();
            runsScored = runType.getRun();
            if(runType == RunType.ONE || runType == RunType.THREE) {
                Player temp = battingTeam.getBattingController().getStriker();
                battingTeam.getBattingController().setStriker(battingTeam.getBattingController().getNonStriker());
                battingTeam.getBattingController().setNonStriker(temp);
            }
        }
        notifyUpdates(this);
    }

    private void notifyUpdates(Ball ballDetails){

        for(ScoreUpdateObserver observer : observerList) {
            observer.updateScore(ballDetails);
        }
    }

    private RunType getRunTypeDetails() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }


    public int getBallNo() {
        return ballNo;
    }

    public void setBallNo(int ballNo) {
        this.ballNo = ballNo;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public Wicket getWicket() {
        return wicket;
    }

    public void setWicket(Wicket wicket) {
        this.wicket = wicket;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public List<ScoreUpdateObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<ScoreUpdateObserver> observerList) {
        this.observerList = observerList;
    }
}
