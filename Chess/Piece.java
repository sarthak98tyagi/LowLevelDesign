package Chess;

public abstract class Piece {

    private COLORSET color;
    private boolean isAlive;

    public Piece(COLORSET color) {
        this.color = color;
        this.isAlive = true;
    }

    public abstract boolean validateMove(Cell initialCell, Cell finalCell);

    public COLORSET getColor() {
        return color;
    }

    public void setColor(COLORSET color) {
        this.color = color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
