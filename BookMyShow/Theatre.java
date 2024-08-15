package BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Theatre {
    private String theatreId;
    private String name;
    private String address;
    private String city;
    private List<Screen> screenList;
    private List<Show> showList;

    public Theatre(String name, String address, String city) {
        this.theatreId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.city = city;
        screenList = new ArrayList<>();
        showList = new ArrayList<>();
    }

    public void addShow(Show show){
        showList.add(show);
    }

    public void addScreen(Screen screen){
        screenList.add(screen);
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public List<Show> getShowListByMovie(String movieName){
        List<Show> shows = new ArrayList<>();
        for(Show show: showList){
            if(show.getMovie().getName().equals(movieName)){
                shows.add(show);
            }
        }
        return shows;
    }
}
