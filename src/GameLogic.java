public class GameLogic {
    // params
    private boolean isCyclic;
    private int fieldSize;
    private int startPercentage;
    private Grid grid;

    GameLogic(boolean isCyclic, int fieldSize, int startPercentage) {
        this.isCyclic = isCyclic;
        this.fieldSize = fieldSize;
        this.startPercentage = startPercentage;

        grid = new Grid(fieldSize);
        grid.initializeGridRandom(startPercentage);
        grid.printGrid();
    }

    void updateGrid() {
        Grid newGrid = new Grid(fieldSize);
        if (isCyclic) {
            for (int y = 0; y < fieldSize; y++) {
                for (int x = 0; x < fieldSize; x++) {

                }
            }
        } else {

        }
    }

    int getActiveNeighbors(int x, int y) {
        int activeNeighbors = 0;
        int[][] neighbors = { { x - 1, y - 1 }, { x, y - 1 }, { x + 1, y - 1 }, { x - 1, y }, { x + 1, y },
                { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 } };
        if (isCyclic) {
            for (int[] arr : neighbors) {
                if (arr[0] < 0) {
                    arr[0] = fieldSize;
                } else if (arr[0] > fieldSize - 1) {
                    arr[0] = 0;
                }
                if (arr[1] < 0) {
                    arr[1] = fieldSize;
                } else if (arr[1] > fieldSize - 1) {
                    arr[1] = 0;
                }
                if (grid.fields[arr[1]][arr[0]]) {
                    activeNeighbors++;
                }
            }
        } else {
            for (int[] arr : neighbors) {
                if (!(arr[0] < 0 || arr[0] > fieldSize - 1 || arr[1] < 0 || arr[1] > fieldSize - 1)) {
                    if (grid.fields[arr[1]][arr[0]]) {
                        activeNeighbors++;
                    }
                }
            }
        }
        return activeNeighbors;

    }

}
