public class VideoGame extends Media {
    private String platform, genre, publisher;
    double copiesSold;

    public VideoGame(String id, String type, String title, String platform, int releaseYear, String genre, String publisher, double copiesSold) {
        this.id = id;
        this.type = type;
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
        return "ID: " + id + ", " + type + ", " + "'" + title + "'" + " published by " + publisher;
    }

}