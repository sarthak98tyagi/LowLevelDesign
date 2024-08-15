package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    private Map<String,List<Theatre>> cityTheatreMap;
    private List<Theatre> theatreList;

    public TheatreController(Map<String, List<Theatre>> cityTheatreMap, List<Theatre> theatreList) {
        this.cityTheatreMap = cityTheatreMap;
        this.theatreList = theatreList;
    }

    public TheatreController(){
        cityTheatreMap = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    public Map<String, List<Theatre>> getCityTheatreMap() {
        return cityTheatreMap;
    }

    public void setCityTheatreMap(Map<String, List<Theatre>> cityTheatreMap) {
        this.cityTheatreMap = cityTheatreMap;
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }

    public void setTheatreList(List<Theatre> theatreList) {
        this.theatreList = theatreList;
    }

    public void addTheatre(Theatre theatre, String city){
        cityTheatreMap.computeIfAbsent(city,el->new ArrayList<>()).add(theatre);
        theatreList.add(theatre);
    }

    public List<Theatre> getTheatres(String city){
        return cityTheatreMap.getOrDefault(city,new ArrayList<>());
    }

    public List<Show> getShows(String city, String movie){
        List<Theatre> theatres = getTheatres(city);
        List<Show> shows = new ArrayList<>();
        for(Theatre theatre : theatres){
            shows.addAll(theatre.getShowListByMovie(movie));
        }
        return shows;
    }

}
