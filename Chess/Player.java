package Chess;

public class Player {

    private String name;
    private COLORSET color;

    public Player(String name, COLORSET color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public COLORSET getColor() {
        return color;
    }

    public void setColor(COLORSET color) {
        this.color = color;
    }

}
