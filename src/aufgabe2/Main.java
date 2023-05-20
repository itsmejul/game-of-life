package aufgabe2;

import de.oop2023.util.UserInterface;

/**
 * Main-Klasse enthaelt nur main-Methode
 */
public class Main {
    /**
     * in der Main-Methode wird eine GameLogic erzeugt und gestartet, mit den von
     * User bestimmten Werten
     * 
     * @param args
     */
    public static void main(String[] args) {

        boolean variant;
        String variantString = UserInterface.in.requestChoiceName("Zyklisch oder offen?", "zyklisch", "offen");
        if (variantString == "zyklisch") {
            variant = true;
        } else {
            variant = false;
        }
        int fieldSize = UserInterface.in.requestInt("Feldgroesse?", 1);
        int startPercentage = UserInterface.in.requestInt("Prozent der Felder, die belegt werden sollen?", 0, 100);
        GameLogic gLogic = new GameLogic(variant, fieldSize, startPercentage);
        gLogic.runGameLoop();
    }
}
