public class Driver {
    private static final Manager M = new Manager();

    public static void main(String[] args) {
        M.readFile("project1dataset.csv");
    }
}
