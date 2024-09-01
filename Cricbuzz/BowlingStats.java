package Cricbuzz;

public class BowlingStats {

    private int oversBowled;
    private int dotBalls;
    private int wickets;
    private double economy;
    private int runs;

    public BowlingStats(){}

    public BowlingStats(int oversBowled, int dotBalls, int wickets, double economy, int runs) {
        this.oversBowled = oversBowled;
        this.dotBalls = dotBalls;
        this.wickets = wickets;
        this.economy = economy;
        this.runs = runs;
    }

    public int getOversBowled() {
        return oversBowled;
    }

    public void setOversBowled(int oversBowled) {
        this.oversBowled = oversBowled;
    }

    public int getDotBalls() {
        return dotBalls;
    }

    public void setDotBalls(int dotBalls) {
        this.dotBalls = dotBalls;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}
