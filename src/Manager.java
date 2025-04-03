import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager {
    private static final ArrayList<Media> MEDIA = new ArrayList<>();

    public void readFile(String fileName) {
        System.out.println("Attempting to read file: " + fileName);
        // Attempt to load the file
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Reading file: " + fileName);
            // Create a new MediaFactory object to create new Media objects
            MediaFactory factory = new MediaFactory();
            // Read the file
            String line = br.readLine();
            while(line != null && !line.isEmpty()) {
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
            System.out.println("File successfully read.");
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

    public Media getOldestProduct() {
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

    public Media getMostPopularMusicAlbum() {
        int sales = 0;
        int arrayIndex = -1;
        // Get initial sales number from the first MusicAlbum in MEDIA
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof MusicAlbum) {
                sales = ((MusicAlbum) MEDIA.get(i)).getGlobalSales();
                arrayIndex = i;
                break;
            }
        }
        // Compare initial sales number to all MusicAlbums in MEDIA and update accordingly
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof MusicAlbum) {
                if(sales < ((MusicAlbum) MEDIA.get(i)).getGlobalSales()) {
                    sales = ((MusicAlbum) MEDIA.get(i)).getGlobalSales();
                    arrayIndex = i;
                }
            }
        }
        return MEDIA.get(arrayIndex);
    }

    public Media getMostPopularVideoGame() {
        double sales = 0;
        int arrayIndex = -1;
        // Get initial sales number from the first VideoGame in MEDIA
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof VideoGame) {
                sales = ((VideoGame) MEDIA.get(i)).getCopiesSold();
                arrayIndex = i;
                break;
            }
        }
        // Compare initial sales number to all VideoGames in MEDIA and update accordingly
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof VideoGame) {
                if(sales < ((VideoGame) MEDIA.get(i)).getCopiesSold()) {
                    sales = ((VideoGame) MEDIA.get(i)).getCopiesSold();
                    arrayIndex = i;
                }
            }
        }
        return MEDIA.get(arrayIndex);
    }

    public String getFilmCommonAgeRating() {
        ArrayList<String> ratingsList = new ArrayList<>();
        // Look through MEDIA for all film products (MotionPicture objects)
        for(Media media : MEDIA) {
            if(media instanceof MotionPicture) {
                // Get and store the ratings of all film products
                ratingsList.add(((MotionPicture) media).getRating());
            }
        }
        // Pass ArrayList to helper method which returns most common film rating
        String[] ratings = ratingsList.toArray(new String[0]);
        return findMostCommonRating(ratings);
    }

    private String findMostCommonRating(String[] ratings) {
        HashMap<String, Integer> ratingsCount = new HashMap<>();
        // Count the number of each rating
        for(String rating : ratings) {
            ratingsCount.put(rating, ratingsCount.getOrDefault(rating, 0) + 1);
        }
        // Find the rating with the highest count
        String mostCommonRating = null;
        int count = 0;
        for(Map.Entry<String, Integer> element : ratingsCount.entrySet()) {
            if(element.getValue() > count) {
                mostCommonRating = element.getKey();
                count = element.getValue();
            }
        }
        return mostCommonRating;
    }

    public Media findShortestMovie() {
        int shortestDuration = 999;
        int arrayIndex = -1;
        // Look through MEDIA to get the initial shortestDuration value from the first Movie object
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof Movie) {
                shortestDuration = ((Movie) MEDIA.get(i)).getDuration();
                arrayIndex = i;
                break;
            }
        }
        // Look through MEDIA to find shortestDuration of all Movie objects
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof Movie) {
                if(shortestDuration > ((Movie) MEDIA.get(i)).getDuration()) {
                    shortestDuration = ((Movie) MEDIA.get(i)).getDuration();
                    arrayIndex = i;
                }
            }
        }
        return MEDIA.get(arrayIndex);
    }

    public Media findShortestMusicAlbum() {
        double shortestDuration = 999;
        int arrayIndex = -1;
        // Look through MEDIA to get the initial shortestDuration value from the first MusicAlbum object
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof MusicAlbum) {
                shortestDuration = ((MusicAlbum) MEDIA.get(i)).getDuration();
                arrayIndex = i;
                break;
            }
        }
        // Look through MEDIA to find shortestDuration of all MusicAlbum objects
        for(int i = 0; i < MEDIA.size(); i++) {
            if(MEDIA.get(i) instanceof MusicAlbum) {
                if(shortestDuration > ((MusicAlbum) MEDIA.get(i)).getDuration()) {
                    shortestDuration = ((MusicAlbum) MEDIA.get(i)).getDuration();
                    arrayIndex = i;
                }
            }
        }
        return MEDIA.get(arrayIndex);
    }
}