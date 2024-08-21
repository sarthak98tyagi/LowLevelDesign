package Chess;

import java.util.Deque;
import java.util.LinkedList;

public class ChesClient {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("Player A",COLORSET.WHITE);
        Player player2 = new Player("Player B", COLORSET.BLACK);
        Deque<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        Game game = new Game(board,players);
        game.play();
    }
}
