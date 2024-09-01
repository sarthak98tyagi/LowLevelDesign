package Cricbuzz;

public class BattingStats {

    private int runsScored;
    private int ballsFaced;
    private int sixHits;
    private int fourHits;
    private double strikeRate;
    private Wicket wicketDetail;

    public BattingStats(int runsScored, int ballsFaced, int sixHits, int fourHits, double strikeRate) {
        this.runsScored = runsScored;
        this.ballsFaced = ballsFaced;
        this.sixHits = sixHits;
        this.fourHits = fourHits;
        this.strikeRate = strikeRate;
    }

    public BattingStats(){

    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public int getSixHits() {
        return sixHits;
    }

    public void setSixHits(int sixHits) {
        this.sixHits = sixHits;
    }

    public int getFourHits() {
        return fourHits;
    }

    public void setFourHits(int fourHits) {
        this.fourHits = fourHits;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Wicket getWicketDetail() {
        return wicketDetail;
    }

    public void setWicketDetail(Wicket wicketDetail) {
        this.wicketDetail = wicketDetail;
    }

}
