package TicTacToe;

public class Move {

    private int i;
    private  int j;
    private Player player;

    public Move(int i, int j, Player player){
        this.i=i;
        this.j=j;
        this.player=player;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
