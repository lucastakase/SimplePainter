import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Grid {
    private int cellSize = 100;
    //private int maxGridX = 50;
    //private int maxGridY = 50;
    private int numbCellX;
    private int numbCellY;

    public Grid(int numbCellX, int numbCellY){
        this.numbCellX = numbCellX;
        this.numbCellY = numbCellY;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getNumbCellX() {
        return numbCellX;
    }

    public int getNumbCellY() {
        return numbCellY;
    }
    String result = "";
    public void makeGrid(){
        for(int i = 0; i < getNumbCellX(); i++){
            for(int j = 0; j < getNumbCellY(); j++){
                Canvas.setMaxX(getCellSize() * getNumbCellX() - 10);
                Canvas.setMaxY(getCellSize() * getNumbCellY() - 10);
                Rectangle cell = new Rectangle(i * getCellSize(),j * getCellSize(), getCellSize(), getCellSize());
                cell.draw();
                //if(j == getNumbCellY() - 1){
                //    result += 0 + "\n";
                //}else {
                //    result += 0 + " ";
                //}
            }

        }
        System.out.println(result);
    }

    public void writeFileByLine(String file, int[] grelha) throws IOException {

        FileWriter writer = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(writer);

        //add text to buffer
        for (int i : grelha) {
            bWriter.write(String.valueOf(i));
            bWriter.newLine();
        }


        bWriter.flush(); // if the buffer is not full, flush will force disk write
        bWriter.close(); // auto-flush is done on close

    }


    private String readFileByLine(String file) throws IOException {

        // create a new file reader
        FileReader reader = new FileReader(file);

        // wrap the file reader using a buffered reader
        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while((line = bReader.) != null) {
            result += line + "\n";
        }

        bReader.close();

        return result;
    }

    /*public void remakeGrid(int x, int y){
        for(int i = 0; i < getNumbCellX(); i++){
            for(int j = 0; j < getNumbCellY(); j++){
                if(j == getNumbCellY() - 1){
                    result += 0 + "\n";
                }else {
                    result += 0 + " ";
                }
            }

        }
    }

     */

}
