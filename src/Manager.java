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

}