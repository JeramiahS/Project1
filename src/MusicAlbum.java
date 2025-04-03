public class MusicAlbum extends Media {
    private String artist, genre;
    private int globalSales, numOfTracks;
    private double duration;

    public MusicAlbum(String id, String type, int releaseYear, String artist, String title, int globalSales, int numOfTracks, double duration, String genre) {
        this.id = id;
        this.type = type;
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

    public int getGlobalSales() {
        return globalSales;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + type + ", '" + title + "' by " + artist;
    }
}