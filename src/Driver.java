public class Driver extends MenuLogic {

    public static void main(String[] args) {
        readFile();
        printMainMenu();
        getInput();
        while(menuOption != 0) {
            processInput();
            printMainMenu();
            getInput();
        }
        System.out.println("Program terminated");
    }

}