package Elevator;

public class Floor {

    private int floor;
    ExternalButton externalButton;

    public Floor(int floor){
        this.floor = floor;
        this.externalButton = new ExternalButton();
    }

    public void pressButton(Direction direction){
        externalButton.pressButton(floor,direction);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ExternalButton getExternalButton() {
        return externalButton;
    }

    public void setExternalButton(ExternalButton externalButton) {
        this.externalButton = externalButton;
    }
}
