public class VideoGame extends Media {
    private String platform, genre, publisher;
    double copiesSold;

    public VideoGame(String id, String title, String platform, int releaseYear, String genre, String publisher, double copiesSold) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }

    public String getPlatform() {
        return platform;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getCopiesSold() {
        return copiesSold;
    }

    @Override
    public String toString() {
        return "Video Game: " + title;
    }

}