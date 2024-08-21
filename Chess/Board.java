package Chess;

public class Board {

    Cell[][] board;

    public Board(){
        board = new Cell[8][8];
        initBoard();
    }

    private void initBoard(){
        int boardLength = board.length;
        //init white set of pieces
        board[0][0] = new Cell(new Rook(COLORSET.WHITE),0,0);
        board[0][boardLength-1] = new Cell(new Rook(COLORSET.WHITE),0,boardLength-1);
        board[0][1] = new Cell(new Knight(COLORSET.WHITE),0,1);
        board[0][boardLength-2] = new Cell(new Knight(COLORSET.WHITE),0,boardLength-2);
        board[0][2] = new Cell(new Bishop(COLORSET.WHITE),0,2);
        board[0][boardLength-3] = new Cell(new Bishop(COLORSET.WHITE),0,boardLength-3);
        board[0][3] = new Cell(new Queen(COLORSET.WHITE),0,3);
        board[0][4] = new Cell(new King(COLORSET.WHITE),0,4);
        for(int j=0;j<boardLength;j++)
            board[1][j] = new Cell(new Pawn(COLORSET.WHITE),1,j);

        //init white set of pieces
        board[boardLength-1][0] = new Cell(new Rook(COLORSET.WHITE),boardLength-1,0);
        board[boardLength-1][boardLength-1] = new Cell(new Rook(COLORSET.WHITE),boardLength-1,boardLength-1);
        board[boardLength-1][1] = new Cell(new Knight(COLORSET.WHITE),boardLength-1,1);
        board[boardLength-1][boardLength-2] = new Cell(new Knight(COLORSET.WHITE),boardLength-1,boardLength-2);
        board[boardLength-1][2] = new Cell(new Bishop(COLORSET.WHITE),boardLength-1,2);
        board[boardLength-1][boardLength-3] = new Cell(new Bishop(COLORSET.WHITE),boardLength-1,boardLength-3);
        board[boardLength-1][3] = new Cell(new Queen(COLORSET.WHITE),boardLength-1,3);
        board[boardLength-1][4] = new Cell(new King(COLORSET.WHITE),boardLength-1,4);
        for(int j=0;j<boardLength;j++)
            board[boardLength-2][j] = new Cell(new Pawn(COLORSET.WHITE),boardLength-2,j);


    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public boolean isValidMove(int initRow, int initCol, int destRow, int destCol){
        if(destCol<0 || destRow<0 || destCol>= board.length || destRow>= board.length || (initRow==destRow) || (initCol==destCol))
            return false;
        Cell initCell = board[initRow][initCol];
        Cell destCell = board[destRow][destCol];
        if(initCell.getPiece()==null || (destCell.getPiece()!=null && destCell.getPiece().getColor() == initCell.getPiece().getColor()))
            return false;
        return initCell.piece.validateMove(initCell, destCell);
    }

    public Cell getCell(int row, int col){
        return board[row][col];
    }

    public boolean checkKill(int initRow, int initCol, int destRow, int destCol){
        Cell initCell = board[initRow][initCol];
        Cell destCell = board[destRow][destCol];
        if(destCell.getPiece()!=null && destCell.getPiece().isAlive() && destCell.getPiece().getColor()!=initCell.getPiece().getColor())
            return true;
        return false;
    }

    public void kill(int initRow, int initCol, int destRow, int destCol){
        Cell initCell = board[initRow][initCol];
        Cell destCell = board[destRow][destCol];
        System.out.println(initCell.getPiece().getColor()+" "+initCell.getPiece().getClass().getName()+" killed"+
                destCell.getPiece().getColor()+" "+destCell.getPiece().getClass().getName());
        destCell.getPiece().setAlive(false);
    }

    public void setCell(int row, int col, Piece piece){
        Cell cell = board[row][col];
        cell.setPiece(piece);
        board[row][col] = cell;
    }

    public boolean isCheckmate(COLORSET color) {
        // TODO: Implement checkmate logic
        return false;
    }

    public boolean isStalemate(COLORSET color) {
        // TODO: Implement stalemate logic
        return false;
    }
}
