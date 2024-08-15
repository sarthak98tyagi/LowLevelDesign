package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    private Map<String,List<Movie>> cityMovieMap;
    private List<Movie> moviesList;

    public MovieController(){
        cityMovieMap = new HashMap<>();
        moviesList = new ArrayList<>();
    }

    public MovieController(Map<String, List<Movie>> cityMovieMap, List<Movie> moviesList) {
        this.cityMovieMap = cityMovieMap;
        this.moviesList = moviesList;
    }

    public Map<String, List<Movie>> getCityMovieMap() {
        return cityMovieMap;
    }

    public void setCityMovieMap(Map<String, List<Movie>> cityMovieMap) {
        this.cityMovieMap = cityMovieMap;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public void addMovie(Movie movie, String city){
        cityMovieMap.computeIfAbsent(city,el->new ArrayList<>()).add(movie);
        if(!moviesList.contains(movie))
            moviesList.add(movie);
    }

    public List<Movie> getMovies(String city){
        return cityMovieMap.getOrDefault(city,new ArrayList<Movie>());
    }

}
