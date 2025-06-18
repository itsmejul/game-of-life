package aufgabe2;

import javax.swing.*;
import java.awt.*;

/**
 * GameOfLifeGUI uses Swing to display the grid
 */
public class GameOfLifeGUI extends JFrame {
    private final JPanel[][] cells;
    private final int size;

    /**
     * Create GUI window with the specified side length
     * 
     * @param size side length of the grid
     */
    public GameOfLifeGUI(int size) {
        this.size = size;
        this.cells = new JPanel[size][size];
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(size, size));
        setSize(800, 800);

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.BLACK);
                cells[y][x] = cell;
                add(cell);
            }
        }

        setVisible(true);
    }

    /**
     * Update GUI grid bsaed on grid state
     * 
     * @param grid the grid instance 
     */
    public void updateGrid(Grid grid) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                cells[y][x].setBackground(grid.getField(x, y) ? Color.GREEN : Color.BLACK);
            }
        }
    }
}
