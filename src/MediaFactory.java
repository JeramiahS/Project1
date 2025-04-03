public class MediaFactory {

    public Media createNewMovie(String[] attributes) {
        String id = attributes[0];
        String type = attributes[1];
        String title = attributes[2];
        String director = attributes[3];
        String country = attributes[4];
        int releaseYear = Integer.parseInt(attributes[5]);
        String rating = attributes[6];
        int duration = Integer.parseInt(attributes[7]);
        String description = attributes[8];

        return new Movie(id, type, title, director, country, releaseYear, rating, duration, description);
    }

    public Media createNewTVShow(String[] attributes) {
        String id = attributes[0];
        String type = attributes[1];
        String title = attributes[2];
        String director = attributes[3];
        String country = attributes[4];
        int releaseYear = Integer.parseInt(attributes[5]);
        String rating = attributes[6];
        String numOfSeasons = attributes[7];
        String description = attributes[8];

        return new TVShow(id, type, title, director, country, releaseYear, rating, numOfSeasons, description);
    }

    public Media createNewVideoGame(String[] attributes) {
        String id = attributes[0];
        String type = attributes[1];
        String title = attributes[2];
        String platform = attributes[3];
        int releaseYear = Integer.parseInt(attributes[4]);
        String genre = attributes[5];
        String publisher = attributes[6];
        double copiesSold = Double.parseDouble(attributes[7]);

        return new VideoGame(id, type, title, platform, releaseYear, genre, publisher, copiesSold);
    }

    public Media createNewMusicAlbum(String[] attributes) {
        String id = attributes[0];
        String type = attributes[1];
        int releaseYear = Integer.parseInt(attributes[2]);
        String artist = attributes[3];
        String title = attributes[4];
        int globalSales = Integer.parseInt(attributes[5]);
        int numOfTracks = Integer.parseInt(attributes[6]);
        double duration = Double.parseDouble(attributes[7]);
        String genre = attributes[8];

        return new MusicAlbum(id, type, releaseYear, artist, title, globalSales, numOfTracks, duration, genre);
    }

}