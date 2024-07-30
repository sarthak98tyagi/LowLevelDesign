package TicTacToe;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    private Board board;

    private Deque<Player> players;

    private Boolean isCompleted;

    private Player winner;

    public TicTacToe(Board board, Deque<Player> players){
        this.board=board;
        this.players=players;
        this.isCompleted=false;
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        while(!isCompleted) {
            Player player = players.pollFirst();
            System.out.println("Please take turn " + player.getPlayerName());
            String cords = sc.nextLine();
            if (cords.length() != 3 || !(Character.isDigit(cords.charAt(0)) && Character.isDigit(cords.charAt(2)) && cords.charAt(1)==' ')) {
                System.out.println("Please Enter move in correct format x y");
                players.addFirst(player);
                continue;
            }
            int x = cords.charAt(0) - '0', y = cords.charAt(2) - '0';
            if (board.isValid(x,y) && board.isFree(x, y)) {
                board.setPiece(x, y, player.getPiece());
            } else {
                System.out.println("Invalid Move");
                players.addFirst(player);
                continue;
            }
            board.displayBoard();
            if(board.isWinner(new Move(x,y,player))){
                System.out.println("Congratulations "+player.getPlayerName()+", you won!");
                isCompleted=true;
                return;
            }
            List<int[]> freeSlotsList = board.getFreeCells();
            if(freeSlotsList==null || freeSlotsList.isEmpty()){
                System.out.println("Match Tied");
                isCompleted=true;
                return;
            }
            players.add(player);
        }
    }

}
