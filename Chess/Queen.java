package Chess;

public class Queen extends Piece{

    public Queen(COLORSET color) {
        super(color);
    }

    @Override
    public boolean validateMove(Cell initialCell, Cell finalCell) {

        int initRow = initialCell.getRow(), initCol = initialCell.getCol(), destRow = finalCell.getRow(), destCol = finalCell.getCol();
        int rowDiff = Math.abs(destRow -initRow);
        int colDiff = Math.abs(destCol - initCol);

        return rowDiff==colDiff || (initRow==destRow || initCol==destCol);

    }
}
