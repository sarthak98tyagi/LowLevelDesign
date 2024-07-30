package TicTacToe;

import java.util.Base64;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GameEngine {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Enter board size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Board board = new Board(n);
        board.displayBoard();
        System.out.println("Enter player X name ");
        String player1Name = sc.next();
        System.out.println("Enter player O name ");
        String player2Name = sc.next();
        Player playerX = new Player(player1Name, new Piece(PieceType.X));
        Player player0 = new Player(player2Name, new Piece(PieceType.O));
        Deque<Player> players = new LinkedList<>();
        players.add(playerX);
        players.add(player0);
        TicTacToe ticTacToe = new TicTacToe(board,players);
        ticTacToe.startGame();
    }
}
