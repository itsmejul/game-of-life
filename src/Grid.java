import java.io.PrintWriter;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Grid ist ein Spielfeld, welches speichert, welche Felder aktuell aktiv sind
 *
 */
public class Grid {
    // private boolean[][] fields;
    /**
     * 2d-Liste, welche den Zustand jedes Feldes an den Koordinaten speichert
     */
    private List<List<Boolean>> fields;

    /**
     * Ein Random-Objekt, um die zufaelligen Belegungen zu generieren
     */
    Random rand = new Random();

    /**
     * Konstruktor erstellt ein neues Grid mit der uebergebenen Feldgroesse
     * 
     * @param fieldSize Die Feldgroesse
     */
    Grid(int fieldSize) {
        // fields = new boolean[fieldSize][fieldSize];
        fields = new ArrayList<List<Boolean>>();
        for (int i = 0; i < fieldSize; i++) {
            fields.add(new ArrayList<Boolean>());
            for (int j = 0; j < fieldSize; j++) {
                fields.get(i).add(j, false);
            }
        }
    }

    /**
     * Setzt ein Feld auf einen neuen Wert
     * 
     * @param newValue der neue Wert des Feldes
     * @param x        der x-Wert des Feldes
     * @param y        der y-Wert des Feldes
     */
    void setField(boolean newValue, int x, int y) {
        fields.get(y).set(x, newValue);
        // fields[y][x] = newValue;
    }

    /**
     * gibt den Status eines Feldes zurueck
     * 
     * @param x der x-Wert des Feldes
     * @param y der y-Wert des Feldes
     * @return der Wert des uebergebenen Feldes
     */

    boolean getField(int x, int y) {
        return fields.get(y).get(x);
        // return fields[y][x];
    }

    /**
     * initialisiert das Feld mit zufaelligen Felder mit der angegebenen
     * Wahrscheinlichkeit
     * 
     * @param startPercentage die Wahrscheinlichkeit, mit der ein Feld belegt wird
     */
    void initializeGridRandom(int startPercentage) {
        /*
         * for (int y = 0; y < fields.length; y++) {
         * for (int x = 0; x < fields[y].length; x++) {
         * int randomInt = rand.nextInt(100);
         * 
         * if (randomInt < startPercentage) {
         * fields[y][x] = true;
         * } else {
         * fields[y][x] = false;
         * }
         * }
         * }
         */
        for (int y = 0; y < fields.size(); y++) {
            for (int x = 0; x < fields.get(y).size(); x++) {
                int randomInt = rand.nextInt(100);

                if (randomInt < startPercentage) {
                    // fields[y][x] = true;
                    setField(true, x, y);
                } else {
                    setField(false, x, y);
                    // fields[y][x] = false;
                }
            }
        }

    }

    /**
     * gibt das Feld in der Konsole mit schoenen Farben aus
     */
    void printGrid() {
        /*
         * String s = "";
         * PrintWriter printWriter = new PrintWriter(System.out, true);
         * for (boolean[] line : fields) {
         * for (boolean field : line) {
         * if (field) {
         * s += "\u001b[0;32m\u001b[40m\u2b1b\u001B[0m";
         * } else {
         * s += "\u001b[40m\u2b1b\u001B[0m";
         * }
         * }
         * s += "\n";
         * }
         * printWriter.println(s);
         */
        String s = "";
        PrintWriter printWriter = new PrintWriter(System.out, true);
        for (List<Boolean> line : fields) {
            for (boolean field : line) {
                if (field) {
                    s += "\u001b[0;32m\u001b[40m\u2b1b\u001B[0m";
                } else {
                    s += "\u001b[40m\u2b1b\u001B[0m";
                }
            }
            s += "\n";
        }
        printWriter.println(s);
    }

    /**
     * Schaut, ob das Feld leer ist
     * 
     * @return den Leerstatus des Feldes
     */
    boolean isEmpty() {
        /*
         * boolean empty = true;
         * for (boolean[] line : fields) {
         * for (boolean field : line) {
         * if (field) {
         * empty = false;
         * }
         * }
         * 
         * }
         * return empty;
         */
        boolean empty = true;
        for (List<Boolean> line : fields) {
            for (boolean field : line) {
                if (field) {
                    empty = false;
                }
            }

        }
        return empty;
    }
}
