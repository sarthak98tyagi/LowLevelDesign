package Chess;

import java.util.Deque;
import java.util.Scanner;

public class Game {

    private Board board;
    private Deque<Player> players;
    private Player winner;
    private GameStatus status;

    public Game(Board board, Deque<Player> players) {
        this.board = board;
        this.players = players;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void play(){
        while(status!=GameStatus.COMPLETED){
            Player player = players.poll();
            System.out.println("Player "+player.getColor()+ " turn");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter source row: ");
            int sourceRow = scanner.nextInt();
            System.out.print("Enter source column: ");
            int sourceCol = scanner.nextInt();
            System.out.print("Enter destination row: ");
            int destRow = scanner.nextInt();
            System.out.print("Enter destination column: ");
            int destCol = scanner.nextInt();
            if(board.isValidMove(sourceRow,sourceCol,destRow,destCol)){
                if(board.checkKill(sourceRow,sourceCol,destRow,destCol)){
                    board.kill(sourceRow,sourceCol,destRow,destCol);
                }
                Cell cell = board.getCell(sourceRow,sourceCol);
                board.setCell(destRow,destCol,cell.getPiece());
                cell.setPiece(null);
                if(isGameOver(players.peek())){
                    status = GameStatus.COMPLETED;
                    winner = player;
                    break;
                }
                players.add(player);
            }
            else{
                System.out.println("Your move is not valid, Please retry");
                players.addFirst(player);
            }

        }
        System.out.println("Winner "+winner.getColor());
    }

    private boolean isGameOver(Player player) {
        return board.isCheckmate(player.getColor()) || board.isStalemate(player.getColor());
    }
}
