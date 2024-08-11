package SnakesAndLadders;

import java.sql.SQLOutput;
import java.util.*;

public class Game {

    private Board board;
    private Deque<Player> players;
    private List<Player> playerRankList;
    private Dice dice;
    private Scanner sc;

    public Game(){
        sc= new Scanner(System.in);
        initBoard();
        dice = new Dice(1);
        addPlayers();
        playerRankList = new ArrayList<>();
    }

    private void initBoard(){
        System.out.println("Enter Board Rows");
        int row = sc.nextInt();
        System.out.println("Enter Board Columns");
        int cols = sc.nextInt();
        System.out.println("Enter Board Snakes Count");
        int snakeCount = sc.nextInt();
        System.out.println("Enter Board Ladder Count");
        int ladderCount = sc.nextInt();
        board = new Board(row,cols,snakeCount,ladderCount);
    }

    private void addPlayers(){
        players = new LinkedList<>();
        System.out.println("Enter number of players: ");
        int numPlayers = sc.nextInt();
        while(numPlayers>0){
            System.out.println("Enter Player Name");
            players.add(new Player(sc.next()));
            System.out.println("Player "+players.getLast().getPlayerName()+" added to game");
            numPlayers--;
        }
    }

    public void start(){
        while(players.size()>1){
            Player player = players.pollFirst();
            System.out.println("Player "+player.getPlayerName()+" chance, roll dice");
            sc.close();
            int diceRoll = dice.roll();
            System.out.println("Current Position: "+player.getCurrentPosition());
            System.out.println("Dice score "+diceRoll);
            int newPosition = player.getCurrentPosition()+diceRoll;
            if(newPosition>=(board.getM()* board.getN())){
                System.out.println("Dice Roll Score exceeded the winning destination point, no move allowed");
                players.addLast(player);
                continue;
            }
            System.out.println("New Position "+ newPosition);
            newPosition  = board.checkJumps(newPosition);
            player.setCurrentPosition(newPosition);
            if(newPosition==(board.getM())* board.getN()-1){
                playerRankList.add(player);
                System.out.println("Wohoooooo, Player "+player.getPlayerName()+" won. Your rank is "+playerRankList.size());
            }
            else{
                players.addLast(player);
            }
        }
        displayPlayersRank();
    }

    private void displayPlayersRank() {
        for(int i=0;i<playerRankList.size();i++){
            System.out.println("Rank "+(i+1)+": "+playerRankList.get(i).getPlayerName());
        }
        if(players!=null && !players.isEmpty())
            System.out.println("Player "+players.peek().getPlayerName()+" lost, better luck next time.");
    }


}
