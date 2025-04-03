public class Driver {
    private static final Manager M = new Manager();

    public static void main(String[] args) {
        M.readFile("project1dataset.csv");
        System.out.println(M.getTotalProducts());
        System.out.println(M.getNumberOfMovies());
        System.out.println(M.getNumberOfTVShows());
        System.out.println(M.getNumberOfVideoGames());
        System.out.println(M.getNumberOfMusicAlbums());
        System.out.println(M.findMostPopularMusicAlbum());
    }
}
