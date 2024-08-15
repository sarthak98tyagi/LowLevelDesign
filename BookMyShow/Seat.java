package BookMyShow;

public class Seat {

    private int seatId;
    private int row;
    private double price;
    private SeatType seatType;

    public Seat(int seatId, int row, double price, SeatType seatType) {
        this.seatId = seatId;
        this.row = row;
        this.price = price;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
