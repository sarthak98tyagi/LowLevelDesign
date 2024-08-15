package BookMyShow;

import java.util.List;
import java.util.UUID;

public class Screen {

    private String screenId;
    private List<Seat> seatList;

    public Screen() {
        this.screenId = UUID.randomUUID().toString();
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

}
