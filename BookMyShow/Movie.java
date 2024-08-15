package BookMyShow;

import java.util.List;

public class Movie {

    private String name;
    private String genre;
    private int duration;
    private List<String> audioLanguages;

    public Movie(String name, String genre, int duration, List<String> audioLanguages) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.audioLanguages = audioLanguages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<String> getAudioLanguages() {
        return audioLanguages;
    }

    public void setAudioLanguages(List<String> audioLanguages) {
        this.audioLanguages = audioLanguages;
    }

}
