package aufgabe2;

import de.oop2023.util.*;

/**
 * GameLogic enthaelt die gesamte Logik fuer ein Spiel und simuliert dieses
 * Spiel
 *
 */
public class GameLogic {
    // params
    /**
     * Wahr, wenn die Feldraender zyklisch sind.
     */
    private boolean isCyclic;
    /**
     * Die Seitenlaenge des Feldes
     */
    private int fieldSize;
    /**
     * Die Wahrscheinlichkeit, dass ein Feld am Anfang belegt wird
     */
    private int startPercentage;
    /**
     * Das Grid-objekt, welches den aktuellen Feldzustand speichert
     */
    private Grid grid;

    /**
     * Konstruktor erstellt ein neues GameLogic-Objekt
     * 
     * @param isCyclic        gibt an, ob die Spielraender zyklisch sind
     * @param fieldSize       die Seitenlaenge des Spielfeldes
     * @param startPercentage die Wahrscheinlichkeit, dass ein am Anfang Feld belegt
     *                        wird
     */
    GameLogic(boolean isCyclic, int fieldSize, int startPercentage) {
        this.isCyclic = isCyclic;
        this.fieldSize = fieldSize;
        this.startPercentage = startPercentage;

        grid = new Grid(fieldSize);
        grid.initializeGridRandom(startPercentage);
        grid.printGrid();

    }

    /**
     * Die Hauptspielschleife, die jede einzelne Runde nacheinander simuliert
     */

    void runGameLoop() {
        while (true) {
            if (grid.isEmpty()) {
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            updateGrid();
            grid.printGrid();
            /*
             * String newRound = UserInterface.in.requestChoiceName("Noch eine Runde?", "y",
             * "n");
             * if (newRound == "n") {
             * System.exit(0);
             * }
             * updateGrid();
             * grid.printGrid();
             */
        }

    }

    /**
     * Updatet das Feld nach den Regeln
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
     * Bestimmt die Anzahl der aktiven Nachbarn eines Feldes
     * 
     * @param x x-Koordinate des Feldes
     * @param y y-Koordinate des Feldes
     * @return die Anzahl der aktiven Nachbarn
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
