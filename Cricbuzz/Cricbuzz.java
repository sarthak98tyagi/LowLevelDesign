package Cricbuzz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cricbuzz {

    public static void main(String args[]) {

        Cricbuzz cb = new Cricbuzz();
        Team teamA = cb.addTeam("India");
        Team teamB = cb.addTeam("SriLanka");
        MatchFormat matchFormat = new T20();
        Match match = new Match(LocalDate.now(),"Terrace",teamA, teamB, matchFormat);
        match.startMatch();

    }

    private Team addTeam(String name) {
        List<Player> playingEleven = new ArrayList<>();
        Player p1 = addPlayer(name+"1",32, PlayerRole.BATSMAN);
        Player p2 = addPlayer(name+"2", 28, PlayerRole.BATSMAN);
        Player p3 = addPlayer(name+"3", 23, PlayerRole.BATSMAN);
        Player p4 = addPlayer(name+"4", 34, PlayerRole.BATSMAN);
        Player p5 = addPlayer(name+"5", 21, PlayerRole.ALL_ROUNDER);
        Player p6 = addPlayer(name+"6", 23, PlayerRole.ALL_ROUNDER);
        Player p7 = addPlayer(name+"7", 25, PlayerRole.BOWLER);
        Player p8 = addPlayer(name+"8", 26, PlayerRole.BOWLER);
        Player p9 = addPlayer(name+"9", 28, PlayerRole.BOWLER);
        Player p10 = addPlayer(name+"10", 29,  PlayerRole.BOWLER);
        Player p11 = addPlayer(name+"11", 30, PlayerRole.BOWLER);

        playingEleven.add(p1);
        playingEleven.add(p2);
        playingEleven.add(p3);
        playingEleven.add(p4);
        playingEleven.add(p5);
        playingEleven.add(p6);
        playingEleven.add(p7);
        playingEleven.add(p8);
        playingEleven.add(p9);
        playingEleven.add(p10);
        playingEleven.add(p11);

        List<Player> bowlers = new ArrayList<>();
        bowlers.add(p7);
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        return new Team(name, playingEleven, bowlers, p1);
    }

    private Player addPlayer(String name, int age, PlayerRole playerType) {
        Person person = new Person(name,age);
        Player player = new Player(person, playerType);
        return player;
    }

}
