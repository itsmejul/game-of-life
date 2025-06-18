package aufgabe2;

import utils.*;
import javax.swing.Timer;

/**
 * GameLogic contains the logic to simulate the game
 *
 */
public class GameLogic {
    /**
     * True, if grid edges behave cyclical
     */
    private boolean isCyclic;
    /**
     * side length of the grid
     */
    private int fieldSize;
    /**
     * probability that a given field is alive at the start
     */
    private int startPercentage;
    /**
     * The grid object where the current state is saved
     */
    private Grid grid;

    /**
     * The GUI object to display the Grid
     */
    private GameOfLifeGUI gui;

    /**
     * Constructor
     * 
     * @param isCyclic        if true, the grid edges behave cyclical
     * @param fieldSize       side length of the grid
     * @param startPercentage probability that a given field is alive at the start
     */
    GameLogic(boolean isCyclic, int fieldSize, int startPercentage) {
        this.isCyclic = isCyclic;
        this.fieldSize = fieldSize;
        this.startPercentage = startPercentage;

        grid = new Grid(fieldSize);
        grid.initializeGridRandom(startPercentage);
        gui = new GameOfLifeGUI(fieldSize);
        gui.updateGrid(grid);
    }

    /**
     * DMain game loop simulates each iteration based on the tick speed
     */
    void runGameLoop() {
        Timer timer = new Timer(100, e -> {
            if (grid.isEmpty()) {
                System.exit(0);
            }
            updateGrid();
            gui.updateGrid(grid);
        });
        timer.start();
    }

    /**
     * Update the grid using Game of Life rules
     */
    void updateGrid() {
        Grid newGrid = new Grid(fieldSize);

        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                int neighbors = getActiveNeighbors(x, y);
                if ((grid.getField(x, y) && (neighbors == 2 || neighbors == 3))
                        || (!grid.getField(x, y) && neighbors >= 3)) {
                    newGrid.setField(true, x, y);
                } else {
                    newGrid.setField(false, x, y);
                }
            }
        }
        grid = newGrid;
    }

    /**
     * Calculate number of alive neighbors of a field
     * 
     * @param x x-coordinate of the field
     * @param y y-coordinate of the field
     * @return number of alive neighbors
     */
    int getActiveNeighbors(int x, int y) {
        int activeNeighbors = 0;
        int[][] neighbors = { { x - 1, y - 1 }, { x, y - 1 }, { x + 1, y - 1 }, { x - 1, y }, { x + 1, y },
                { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 } };
        if (isCyclic) {
            for (int[] arr : neighbors) {
                if (arr[0] < 0) {
                    arr[0] = fieldSize - 1;
                } else if (arr[0] > fieldSize - 1) {
                    arr[0] = 0;
                }
                if (arr[1] < 0) {
                    arr[1] = fieldSize - 1;
                } else if (arr[1] > fieldSize - 1) {
                    arr[1] = 0;
                }
                if (grid.getField(arr[0], arr[1])) {
                    activeNeighbors++;
                }
            }
        } else {
            for (int[] arr : neighbors) {
                if (!(arr[0] < 0 || arr[0] > fieldSize - 1 || arr[1] < 0 || arr[1] > fieldSize - 1)) {
                    if (grid.getField(arr[0], arr[1])) {
                        activeNeighbors++;
                    }
                }
            }
        }
        return activeNeighbors;
    }
}
