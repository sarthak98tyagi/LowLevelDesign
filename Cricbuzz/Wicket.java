package Cricbuzz;

public class Wicket {

    private WicketType wicketType;
    private Over over;
    private Ball ball;

    public Wicket(WicketType wicketType, Over over, Ball ball) {
        this.wicketType = wicketType;
        this.over = over;
        this.ball = ball;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public Over getOver() {
        return over;
    }

    public void setOver(Over over) {
        this.over = over;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

}
