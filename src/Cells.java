import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cells {
    private Rectangle rectangle; //Represents the rectangular area of the cell on the screen
    private int color; //Stores the color of the cell (0: white, 1: black, 2: blue)

    public Cells(int col, int row){ //Constructor, creates a new cell at the specified column and row
        this.rectangle = new Rectangle(Grid.colToX(col), Grid.rowToY(row), Grid.CELLSIZE, Grid.CELLSIZE);
        rectangle.draw(); //Draws the rectangle representing the cell on the screen
    }

    public void paintBlack(){ //Paints the cell black
        rectangle.fill(); //Fills the rectangle with the specified color
        rectangle.setColor(Color.BLACK); //Sets the color of the rectangle to black
        color = 1; //Updates the cell color attribute
    }

    public void paintBlue(){ //Paints the cell blue
        rectangle.fill();
        rectangle.setColor(Color.BLUE);
        color = 2;
    }

    public void erase(){ //Erases the cell (sets it to white)
        rectangle.draw(); //Draws the rectangle outline, effectively erasing the fill
        rectangle.setColor(Color.BLACK); //Sets the color to black (this might be redundant)
        color = 0; //Updates the cell color attribute
    }

    public int getColor(){ //Returns the current color of the cell
        return color;
    }
}
