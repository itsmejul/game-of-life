package aufgabe2;

import utils.UserInterface;

/**
 * Main class only contains the main method
 */
public class Main {
    /**
     * In the main method, a GameLogic instance is created based on the values submitted by the user
     * 
     * @param args
     */
    public static void main(String[] args) {

        boolean variant;
        String variantString = UserInterface.in.requestChoiceName("Should the grid borders behave cyclic or open?", "cyclic", "open");
        if (variantString == "cyclic") {
            variant = true;
        } else {
            variant = false;
        }
        int fieldSize = UserInterface.in.requestInt("What side length should the grid have? (recommended 40)", 1);
        int startPercentage = UserInterface.in.requestInt("What percentage of fields should be randomly alive at the start? (recommended 10)", 0, 100);
        GameLogic gLogic = new GameLogic(variant, fieldSize, startPercentage);
        gLogic.runGameLoop();
    }
}
