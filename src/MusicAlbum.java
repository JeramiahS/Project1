public class MusicAlbum extends Media {
    private String artist, genre;
    private int numOfTracks;
    private double globalSales, duration;

    public MusicAlbum(String id, int releaseYear, String artist, String title, double globalSales, int numOfTracks, double duration, String genre) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.title = title;
        this.globalSales = globalSales;
        this.numOfTracks = numOfTracks;
        this.duration = duration;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public double getGlobalSales() {
        return globalSales;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    private double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return id + " Music Album: " + title;
    }
}