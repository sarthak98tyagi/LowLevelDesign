package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] board;

    private  int n;

    public Board(int n){
        this.n=n;
        board=new Piece[n][n];
    }

    public List<int[]> getFreeCells(){
        List<int[]> freeSlots = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==null){
                    freeSlots.add(new int[]{i,j});
                }
            }
        }
        return freeSlots;
    }

    public void setPiece(int i, int j, Piece piece){
        board[i][j]=piece;
    }

    public boolean isFree(int x, int y){
        return board[x][y]==null;
    }

    public boolean isValid(int x, int y){
        if(x>=0 && y>=0 && x<n && y<n)
            return true;
        return false;
    }

    public boolean isWinner(Move move){
        int x=move.getI(), y = move.getJ();
        Piece piece = move.getPlayer().getPiece();
        boolean victory = true;
        //check in row
        for(int j=0;j<n;j++){
            if(board[x][j]==null || board[x][j].pieceType!=piece.pieceType) {
                victory=false;
                break;
            }
        }
        if(victory)
            return victory;
        victory=true;
        //check in column
        for(int i=0;i<n;i++){
            if(board[i][y]==null || board[i][y].pieceType!=piece.pieceType){
                victory=false;
                break;
            }
        }
        if(victory)
            return victory;
        victory = true;
        if(x==y) {
            //check left diagonal
            for (int i = 0; i < n; i++) {
                    if (board[i][i] == null || board[i][i].pieceType != piece.pieceType) {
                        victory = false;
                        break;
                    }
            }
            if(victory)
                return victory;
        }

        victory=true;
        if((x+y)==(n-1)){
            for(int i=0;i<n;i++){
                    if(board[i][n-1-i]==null || board[i][n-1-i].pieceType!=piece.pieceType){
                        victory=false;
                        break;
                    }
            }
            if(victory)
                return victory;
        }

        return false;
    }

    public void displayBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String ch = board[i][j]==null?" ":(board[i][j].pieceType==PieceType.X?"X":"O");
                if(j<(n-1))
                    System.out.print(ch+" | ");
                else
                    System.out.println(ch+" ");
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
