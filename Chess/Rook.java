package Chess;

public class Rook extends Piece{

    public Rook(COLORSET color) {
        super(color);
    }

    @Override
    public boolean validateMove(Cell initialCell, Cell finalCell) {

        int initRow = initialCell.getRow(), initCol = initialCell.getCol(), destRow = finalCell.getRow(), destCol = finalCell.getCol();
        int rowDiff = destRow -initRow;
        int colDiff = destCol - initCol;

        if(Math.abs(rowDiff)==0 || Math.abs(colDiff)==0)
            return true;
        return false;

    }
}
