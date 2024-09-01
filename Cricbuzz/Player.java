package Cricbuzz;

public class Player{
    private Person person;
    private PlayerRole playerRole;
    private BattingStats battingStats;
    private BowlingStats bowlingStats;

    public Player(Person person, PlayerRole playerRole) {
        this.person = person;
        this.playerRole = playerRole;
        battingStats = new BattingStats();
        bowlingStats = new BowlingStats();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    public BattingStats getBattingStats() {
        return battingStats;
    }

    public void setBattingStats(BattingStats battingStats) {
        this.battingStats = battingStats;
    }

    public BowlingStats getBowlingStats() {
        return bowlingStats;
    }

    public void setBowlingStats(BowlingStats bowlingStats) {
        this.bowlingStats = bowlingStats;
    }

    public void printBattingScoreCard() {
        System.out.println("PlayerName: " + person.getName() + " -- totalRuns: " + battingStats.getRunsScored()
                + " -- totalBallsPlayed: " + battingStats.getBallsFaced() + " -- 4s: " + battingStats.getFourHits()
                + " -- 6s: " + battingStats.getSixHits() + " -- outby: " +   ((battingStats.getWicketDetail() != null) ? battingStats.getWicketDetail().getOver().getBowledBy().getPerson().getName() : "notout"));
    }

    public void printBowlingScoreCard() {
        System.out.println("PlayerName: " + person.getName() + " -- totalOversThrown: " + bowlingStats.getOversBowled()
                + " -- totalRunsGiven: " + bowlingStats.getRuns() + " -- WicketsTaken: " + bowlingStats.getWickets());
    }
}
