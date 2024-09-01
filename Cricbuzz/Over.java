package Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private int overNo;
    private List<Ball> balls;
    private int runScored;
    private int wicketsTaken;
    private Player bowledBy;
    private int extraBallsCount;

    public Over(){}

    public Over(Player bowledBy, int overNo) {
        balls = new ArrayList<>();
        this.bowledBy = bowledBy;
        this.overNo = overNo;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin){
        int ballCount = 1;
        while(ballCount<=6){

            Ball ball = new Ball(ballCount);
            ball.deliverBall(battingTeam, bowlingTeam, this);
            if(ball.getBallType() == BallType.LEGAL) {
                balls.add(ball);
                ballCount++;
                if(ball.getWicket() != null) {
                    battingTeam.getBattingController().setStriker(null);
                }
                if( runsToWin!= -1 && battingTeam.getTotalRuns() >= runsToWin){
                    battingTeam.setWinner(true);
                    return true;
                }
            }
            else {
                extraBallsCount++;
            }
        }

        return false;
    }

    public int getOverNo() {
        return overNo;
    }

    public void setOverNo(int overNo) {
        this.overNo = overNo;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public int getRunScored() {
        return runScored;
    }

    public void setRunScored(int runScored) {
        this.runScored = runScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public int getExtraBallsCount() {
        return extraBallsCount;
    }

    public void setExtraBallsCount(int extraBallsCount) {
        this.extraBallsCount = extraBallsCount;
    }
}
