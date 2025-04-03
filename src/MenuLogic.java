import java.util.Scanner;
public class MenuLogic {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Manager M = new Manager();
    protected static int menuOption;

    public static void readFile() {
        M.readFile("project1dataset.csv");
    }

    public static void printMainMenu() {
        System.out.println("Enter a number to perform an action:");
        System.out.println("1. Count total products");
        System.out.println("2. Count total Movies");
        System.out.println("3. Count total TV Shows");
        System.out.println("4. Count total Video Games");
        System.out.println("5. Count total Music Albums");
        System.out.println("6. Find the oldest product");
        System.out.println("7. Find the most popular music album");
        System.out.println("8. Find the most popular video game");
        System.out.println("9. Find the most common age rating for film products");
        System.out.println("10. Find the shortest movie");
        System.out.println("11. Find the shortest music album");
        System.out.println("0. Exit");
    }

    public static void getInput() {
        menuOption = SCANNER.nextInt();
    }

    public static void processInput() {
        switch(menuOption) {
            case 1:
                System.out.println("Total products: " + M.getTotalProducts());
                break;
            case 2:
                System.out.println("Total Movies: " + M.getNumberOfMovies());
                break;
            case 3:
                System.out.println("Total TV Shows: " + M.getNumberOfTVShows());
                break;
            case 4:
                System.out.println("Total Video Games: " + M.getNumberOfVideoGames());
                break;
            case 5:
                System.out.println("Total Music Albums: " + M.getNumberOfMusicAlbums());
                break;
            case 6:
                System.out.println("Oldest product: " + M.getOldestProduct());
                break;
            case 7:
                System.out.println("Most popular music album: " + M.getMostPopularMusicAlbum());
                break;
            case 8:
                System.out.println("Most popular video game: " + M.getMostPopularVideoGame());
                break;
            case 9:
                System.out.println("Most common film rating: " + M.getFilmCommonAgeRating());
                break;
            case 10:
                System.out.println("Shortest movie: " + M.findShortestMovie());
                break;
            case 11:
                System.out.println("Shortest music album: " + M.findShortestMusicAlbum());
                break;
        }
    }

}