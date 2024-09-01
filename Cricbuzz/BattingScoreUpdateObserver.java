package Cricbuzz;

public class BattingScoreUpdateObserver implements ScoreUpdateObserver{
    @Override
    public void updateScore(Ball ball) {
        Player batsman = ball.getPlayedBy();
        batsman.getBattingStats().setBallsFaced(batsman.getBattingStats().getBallsFaced()+1);
        if(ball.getWicket()!=null){
            batsman.getBattingStats().setWicketDetail(ball.getWicket());
        }
        else{
            int runs = ball.getRunType().getRun();
            batsman.getBattingStats().setRunsScored(batsman.getBattingStats().getRunsScored()+runs);
            if(ball.getRunType()==RunType.FOUR){
                batsman.getBattingStats().setFourHits(batsman.getBattingStats().getFourHits()+1);
            }
            else if(ball.getRunType()==RunType.SIX){
                batsman.getBattingStats().setSixHits(batsman.getBattingStats().getSixHits()+1);
            }
        }
    }
}
