import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.IOException;

public class Painter {
    private Rectangle painter; //Represents the painter (a rectangle) on the screen
    private Grid grid; //Reference to the grid object
    private int col; //Current column position of the painter on the grid
    private int row; //Current row position of the painter on the grid
    private int gridMaxX; //Maximum number of columns in the grid
    private int gridMaxY; //Maximum number of rows in the grid

    public Painter(int col, int row, Grid grids) { //Constructor, initializes the painter with initial position and grid reference
        this.col = col;
        this.row = row;
        grid = grids;
        gridMaxX = grid.getNumbCellX();
        gridMaxY = grid.getNumbCellY();

        painter = new Rectangle(Grid.colToX(col), Grid.rowToY(row), Grid.CELLSIZE, Grid.CELLSIZE);
        painter.setColor(Color.RED); //Sets the painter color to red
        painter.fill(); //Fills the painter rectangle
    }

    public void moveLeft() { //Moves the painter one cell to the left
        if (painter.getX() > Grid.PADDING) { //Checks if the painter is not at the leftmost edge
            painter.translate(-Grid.CELLSIZE, 0); //Moves the painter left by one cell size
            col--; //Updates the painter's column position
        }
    }

    public void moveRight() { //Moves the painter one cell to the right
        if (painter.getX() < Grid.colToX(gridMaxX) - Grid.CELLSIZE) { //Checks if the painter is not at the rightmost edge
            painter.translate(Grid.CELLSIZE, 0); //Moves the painter right by one cell size
            col++; //Updates the painter's column position
        }
    }

    public void moveUp() { //Moves the painter one cell up
        if (painter.getY() > Grid.PADDING) { //Checks if the painter is not at the top edge
            painter.translate(0, -Grid.CELLSIZE); //Moves the painter up by one cell size
            row--; //Updates the painter's row position
        }
    }

    public void moveDown() { //Moves the painter one cell down
        if (painter.getY() < Grid.rowToY(gridMaxY) - Grid.CELLSIZE) { //Checks if the painter is not at the bottom edge
            painter.translate(0, Grid.CELLSIZE); //Moves the painter down by one cell size
            row++; //Updates the painter's row position
        }
    }

    public void paintBlack() { //Paints the current cell black
        Cells cell = grid.getCell(col, row); //Gets the cell at the current painter position
        cell.paintBlack(); //Paints the cell black
    }

    public void erase() { //Erases the current cell
        Cells cells = grid.getCell(col, row); //Gets the cell at the current painter position
        cells.erase(); //Erases the cell
    }

    public void paintBlue() { //Paints the current cell blue
        Cells cell = grid.getCell(col, row); //Gets the cell at the current painter position
        cell.paintBlue(); //Paints the cell blue
    }

    public void save() { //Saves the current state of the grid to a file
        try {
            grid.saveGrid();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() { //Loads a saved grid state from a file
        try {
            grid.loadGrid();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear() { //Clears the entire grid (erases all cells)
        grid.clear();
    }
}