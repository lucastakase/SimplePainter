import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Grid {
    public static final int CELLSIZE = 20; //Size of each cell in pixels
    public static final int PADDING = 10; //Padding around the grid on the screen
    private int numbCellX; //Number of columns in the grid
    private int numbCellY; //Number of rows in the grid
    private Cells[][] cells; //2D array representing the grid cells

    public Grid(int numbCellX, int numbCellY) { //Constructor, initializes the grid with specified dimensions
        this.numbCellX = numbCellX;
        this.numbCellY = numbCellY;

        cells = new Cells[numbCellX][numbCellY]; //Creates the 2D array of cells

        for (int i = 0; i < numbCellX; i++) {
            for (int j = 0; j < numbCellY; j++) {
                cells[i][j] = new Cells(i, j); //Creates a new cell at each position in the grid
            }
        }
    }

    public Cells getCell(int col, int row) { //Returns the cell at the specified column and row
        return cells[col][row];
    }

    public static int colToX(int col) { //Converts a grid column coordinate to screen X coordinate
        return col * CELLSIZE + PADDING;
    }

    public static int rowToY(int row) { //Converts a grid row coordinate to screen Y coordinate
        return row * CELLSIZE + PADDING;
    }

    public int getNumbCellX() { //Returns the number of columns in the grid
        return numbCellX;
    }

    public int getNumbCellY() { //Returns the number of rows in the grid
        return numbCellY;
    }

    public void saveGrid() throws IOException { //Saves the grid state to a file
        StringBuilder result = new StringBuilder(); //Stores the grid data as a string
        for (int i = 0; i < numbCellX; i++) {
            for (int j = 0; j < numbCellY; j++) {
                if (getCell(i, j).getColor() == 1) { //If cell is black, add "1"
                    result.append("1");
                }
                if (getCell(i, j).getColor() == 2) { //If cell is blue, add "2"
                    result.append("2");
                } else { //If cell is white, add "0"
                    result.append("0");
                }
            }
        }
        BufferedWriter bWriter = new BufferedWriter(new FileWriter("Resources/save.txt")); //Creates a file writer
        bWriter.write(String.valueOf(result)); //Writes the grid data to the file
        bWriter.flush(); //Ensures data is written to the file
        bWriter.close(); //Closes the file writer
    }

    public void loadGrid() throws IOException { //Loads grid state from a file
        BufferedReader bReader = new BufferedReader(new FileReader("Resources/save.txt")); //Creates a file reader
        String result = bReader.readLine(); //Reads the grid data from the file
        int index = 0; //Index for iterating through the grid data string
        for (int i = 0; i < numbCellY; i++) { //Iterates over the grid cells
            for (int j = 0; j < numbCellY; j++) {
                Cells cells = getCell(i, j); //Gets the current cell
                if (result.charAt(index) == '1') { //If data is "1", paint the cell black
                    cells.paintBlack();
                } else if (result.charAt(index) == '2') { //If data is "2", paint the cell blue
                    cells.paintBlue();
                } else { //If data is "0", erase the cell
                    cells.erase();
                }
                index++; //Increment the index to the next character in the string
            }
        }
    }

    public void clear() { //Clears the grid (erases all cells)
        for (int i = 0; i < numbCellX; i++) {
            for (int j = 0; j < numbCellY; j++) {
                cells[i][j].erase(); //Erases each cell in the grid
            }
        }
    }
}
