import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
    private static final ArrayList<Media> MEDIA_ARRAY_LIST = new ArrayList<>();

    public void readFile(String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while(line != null) {
                String[] splitLine = line.split("'");
                switch(splitLine[1]) {
                    case "Movie":
                        MEDIA_ARRAY_LIST.add(new Movie());
                        break;
                    case "TV Show":
                        break;
                }
                br.readLine();
            }
        }
        catch(IOException e) {
            System.out.println("File not found");
        }
    }

}