package Chess;

public class Knight extends Piece{

    public Knight(COLORSET color) {
        super(color);
    }

    @Override
    public boolean validateMove(Cell initialCell, Cell finalCell) {
        int initRow = initialCell.getRow(), initCol = initialCell.getCol(), destRow = finalCell.getRow(), destCol = finalCell.getCol();
        int rowDiff = Math.abs(destRow -initRow);
        int colDiff = Math.abs(destCol - initCol);
        return (rowDiff==2 && colDiff==1) || (colDiff==2 && rowDiff==1);
    }

}
