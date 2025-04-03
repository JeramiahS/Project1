import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
    private static final ArrayList<Media> MEDIA = new ArrayList<>();

    public void readFile(String fileName) {
        // Attempt to load the file
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Create a new MediaFactory object to create new Media objects
            MediaFactory factory = new MediaFactory();
            // Read the file
            String line = br.readLine();
            while(line != null) {
                // Split the current line of text apart by every comma to get media attributes
                String[] attributes = line.split(",");
                // Attributes get changed line-by-line. An object must be created based on the updated attributes list
                switch(attributes[1]) {
                    case "Movie":
                        MEDIA.add(factory.createNewMovie(attributes));
                        break;
                    case "TV Show":
                        MEDIA.add(factory.createNewTVShow(attributes));
                        break;
                    case "Video Game":
                        MEDIA.add(factory.createNewVideoGame(attributes));
                        break;
                    case "Music Album":
                        MEDIA.add(factory.createNewMusicAlbum(attributes));
                        break;
                }
                // Read the next line of text
                line = br.readLine();
            }
        }
        catch(IOException e) {
            System.out.println("File not found");
        }
    }

    public int getTotalProducts() {
        int numOfProducts = 0;
        for(Media _ : MEDIA) {
            numOfProducts++;
        }
        return numOfProducts;
    }

    public int getNumberOfMovies() {
        int numOfMovies = 0;
        for(Media media : MEDIA) {
            if(media instanceof Movie) {
                numOfMovies++;
            }
        }
        return numOfMovies;
    }

    public int getNumberOfTVShows() {
        int numOfShows = 0;
        for(Media media : MEDIA) {
            if(media instanceof TVShow) {
                numOfShows++;
            }
        }
        return numOfShows;
    }

    public int getNumberOfVideoGames() {
        int numOfGames = 0;
        for(Media media : MEDIA) {
            if(media instanceof VideoGame) {
                numOfGames++;
            }
        }
        return numOfGames;
    }

    public int getNumberOfMusicAlbums() {
        int numOfAlbums = 0;
        for(Media media : MEDIA) {
            if(media instanceof MusicAlbum) {
                numOfAlbums++;
            }
        }
        return numOfAlbums;
    }

    public Media findOldestProduct() {
        int year = MEDIA.getFirst().getReleaseYear();
        int arrayIndex = -1;
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i).getReleaseYear() < year) {
                year = MEDIA.get(i).getReleaseYear();
                arrayIndex = i;
            }
        }
        return MEDIA.get(arrayIndex);
    }

    public Media findMostPopularMusicAlbum() {
        double numOfSales;
        int arrayIndex = 0;
        // Look through the array for MusicAlbum objects
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof MusicAlbum) {
                // If object is a Music Album, then get the initial double value
                numOfSales = ((MusicAlbum) MEDIA.get(i)).getGlobalSales();
                // Keep track of the array index to return the right object from the MEDIA array
                arrayIndex = i;
                // Check if the next value is greater than the initial value and so forth
                if(((MusicAlbum) MEDIA.get(i)).getGlobalSales() > numOfSales) {
                    // Update value and get new index if true
                    numOfSales = ((MusicAlbum) MEDIA.get(i)).getGlobalSales();
                    arrayIndex = i;
                }
            }
        }
        return MEDIA.get(arrayIndex);
    }

}