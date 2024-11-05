import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.IOException;

public class Painter {
    private Rectangle painter;
    private Grid grid;
    public Painter(){
    }

    private int painterSize;
    private int gridMaxX;
    private int gridMaxY;
    private int numbCell;

    public int[] grelha;


    public void setPainterSize(int painterSize){
        this.painterSize = painterSize;
    }
    public void setGridMaxX(int gridMaxX){
        this.gridMaxX = gridMaxX;
    }
    public void setGridMaxY(int gridMaxY){
        this.gridMaxY = gridMaxY;
    }
    public void setNumbCell(int numbCell){
        this.numbCell = numbCell;
    }
    public void createPainter(Grid grid){
        setGridMaxX(grid.getNumbCellX() * grid.getCellSize());
        setGridMaxY(grid.getNumbCellY() * grid.getCellSize());
        setPainterSize(grid.getCellSize());
        setNumbCell(grid.getNumbCellX());
        painter = new Rectangle(0, 0, painterSize, painterSize);
        painter.setColor(Color.CYAN);
        painter.fill();
        grelha = new int[(gridMaxX/painterSize) * (gridMaxY/painterSize)];

    }


    public void moveLeft(){
        if(painter.getX() > 0) {
            painter.translate(-painterSize, 0);
        }
    }
    public void moveRight(){
        if(painter.getX() < gridMaxX - painterSize ) {
            painter.translate(painterSize, 0);
        }
    }
    public void moveUp(){
        if(painter.getY() > 0) {
            painter.translate(0, -painterSize);
        }
    }
    public void moveDown(){
        if(painter.getY() < gridMaxY - painterSize) {
            painter.translate(0, painterSize);
        }
    }
    public void paintBlack(){
        Rectangle black = new Rectangle(painter.getX(), painter.getY(), painterSize, painterSize);
        black.fill();
        black.setColor(Color.BLACK);
        grelha[((painter.getY()*numbCell)/painterSize)+(painter.getX()/painterSize)] = 1;


    }
    public void erase(){
        grelha[((painter.getY()*numbCell)/painterSize)+(painter.getX()/painterSize)] = 0;
    }
    public void paintBlue(){
        Rectangle black = new Rectangle(painter.getX(), painter.getY(), painterSize, painterSize);
        black.fill();
        black.setColor(Color.BLUE);
        grelha[((painter.getY()*numbCell)/painterSize)+(painter.getX()/painterSize)] = 2;
    }
    public void save() throws IOException {
        grid = new Grid(numbCell, numbCell);
        grid.writeFileByLine("grelha.txt", grelha);
       for(int g : grelha){
           System.out.println(g);

                //if(j == getNumbCellY() - 1){
                //    result += 0 + "\n"
                //}else {
                //    result += 0 + " ";
                //}


        }
    //    painter.
    }
    public void load(){
      //  painter.
    }
    public void clear(){

    }


}
