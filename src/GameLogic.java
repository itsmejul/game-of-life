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

}
