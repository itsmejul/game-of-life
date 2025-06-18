package aufgabe2;

import java.io.PrintWriter;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Grid is used to store the state of all fields, which are currently alive or dead
 *
 */
public class Grid {
    // private boolean[][] fields;
    /**
     * 2d-list, saves the state of every field at the coordinates
     */
    private List<List<Boolean>> fields;

    /**
     * Random object is used to create random alive coordinates at the start
     */
    Random rand = new Random();

    /**
     * Constructor creates a new Grid with the specified side length
     * 
     * @param fieldSize the length of one side
     */
    Grid(int fieldSize) {
        fields = new ArrayList<List<Boolean>>();
        for (int i = 0; i < fieldSize; i++) {
            fields.add(new ArrayList<Boolean>());
            for (int j = 0; j < fieldSize; j++) {
                fields.get(i).add(j, false);
            }
        }
    }

    /**
     * Update a field to a new value
     * 
     * @param newValue the new value of the field
     * @param x        x-coordinate of the field
     * @param y        y-coordinate of the field
     */
    void setField(boolean newValue, int x, int y) {
        fields.get(y).set(x, newValue);
    }

    /**
     * Get the current state of a field
     * 
     * @param x x-coordinate of the field
     * @param y y-coordinate of the field
     * @return current state of the field
     */

    boolean getField(int x, int y) {
        return fields.get(y).get(x);
    }

    /**
     * Initialize the grid randomly based on the start percentage
     * 
     * @param startPercentage probability, that a field is alive at the start
     */
    void initializeGridRandom(int startPercentage) {

        for (int y = 0; y < fields.size(); y++) {
            for (int x = 0; x < fields.get(y).size(); x++) {
                int randomInt = rand.nextInt(100);

                if (randomInt < startPercentage) {
                    setField(true, x, y);
                } else {
                    setField(false, x, y);
                }
            }
        }

    }

    /**
     * Prints the Grid to console (not used anymore)
     */
    void printGrid() {
        String s = "";
        PrintWriter printWriter = new PrintWriter(System.out, true);
        for (List<Boolean> line : fields) {
            for (boolean field : line) {
                if (field) {
                    s += "\u001b[42m \u001b[0m";
                } else {
                    s += "\u001b[40m \u001b[0m";
;
                }
            }
            s += "\n";
        }
        printWriter.println(s);
    }

    /**
     * Check if a grid is completely empty
     * 
     * @return emptiness of the grid
     */
    boolean isEmpty() {
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
