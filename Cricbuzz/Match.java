package Cricbuzz;

import java.time.LocalDate;

public class Match {
    private LocalDate date;
    private String venue;
    private Team teamA;
    private Team teamB;
    private Team tossWinner;
    private Inning[] innings;
    private MatchFormat matchFormat;
    private MatchStatus matchStatus;
    private MatchResult matchResult;
    private Team winner;

    public Match(LocalDate date, String venue, Team teamA, Team teamB, MatchFormat matchFormat) {
        this.date = date;
        this.venue = venue;
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchFormat = matchFormat;
        this.innings = new Inning[2];
    }

    public void startMatch() {
        tossWinner = toss(teamA, teamB);
        for(int inning=1; inning<=2; inning++){

            Inning inningDetails;
            Team bowlingTeam;
            Team battingTeam;

            if(inning == 1){
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new Inning(battingTeam, bowlingTeam, matchFormat);
                inningDetails.start( -1);

            }else {
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new Inning(battingTeam, bowlingTeam, matchFormat);
                inningDetails.start(innings[0].getTotalRuns());
                if(bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                    bowlingTeam.setWinner(true);
                }
            }


            innings[inning-1] = inningDetails;

            System.out.println();
            System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.getTeamName() + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.getTeamName() + "---");
            bowlingTeam.printBowlingScoreCard();

        }

        System.out.println();
        if(teamA.isWinner()){
            System.out.println("---WINNER---" + teamA.getTeamName());

        }else {
            System.out.println("---WINNER---" + teamB.getTeamName());

        }

    }

    private Team toss(Team teamA, Team teamB){
        if(Math.random() < 0.5) {
            return teamA;
        } else {
            return teamB;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Team getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(Team tossWinner) {
        this.tossWinner = tossWinner;
    }

    public Inning[] getInnings() {
        return innings;
    }

    public void setInnings(Inning[] innings) {
        this.innings = innings;
    }

    public MatchFormat getMatchFormat() {
        return matchFormat;
    }

    public void setMatchFormat(MatchFormat matchFormat) {
        this.matchFormat = matchFormat;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
