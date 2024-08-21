package Chess;

public class Pawn extends Piece{

    public Pawn(COLORSET color){
        super(color);
    }
    @Override
    public boolean validateMove(Cell initialCell, Cell finalCell) {
        //logic
        int initRow = initialCell.getRow(), initCol = initialCell.getCol(), destRow = finalCell.getRow(), destCol = finalCell.getCol();
        int rowDiff = destRow -initRow;
        int colDiff = destCol - initCol;
        if(initialCell.getPiece().getColor()==COLORSET.WHITE){
            return rowDiff == 1 && colDiff == 0 || initRow == 1 && rowDiff == 2 && colDiff == 0 || rowDiff == 1 && colDiff == 1 && finalCell.getPiece() != null && finalCell.getPiece().isAlive() &&finalCell.getPiece().getColor() == COLORSET.BLACK;
        }
        else{
            return rowDiff == -1 && colDiff == 0 || initRow == 6 && rowDiff == -2 && colDiff == 0 || rowDiff == 1 && colDiff == 1 && finalCell.getPiece() != null && finalCell.getPiece().isAlive() && finalCell.getPiece().getColor() == COLORSET.WHITE;
        }
    }
}
