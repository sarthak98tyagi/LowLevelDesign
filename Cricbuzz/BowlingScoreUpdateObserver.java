package Cricbuzz;

public class BowlingScoreUpdateObserver implements ScoreUpdateObserver{
    @Override
    public void updateScore(Ball ball) {
        Player bowler = ball.getBowledBy();
        if(ball.getBallNo()==6 && ball.getBallType()==BallType.LEGAL){
            bowler.getBowlingStats().setOversBowled(bowler.getBowlingStats().getOversBowled()+1);
        }
        if(ball.getWicket()!=null){
            bowler.getBowlingStats().setWickets(bowler.getBowlingStats().getWickets()+1);
        }
        else if(ball.getRunType()==RunType.DOT){
            bowler.getBowlingStats().setDotBalls(bowler.getBowlingStats().getDotBalls()+1);
        }
        else{
            bowler.getBowlingStats().setRuns(bowler.getBowlingStats().getRuns()+ball.getRunType().getRun());
        }
    }
}
