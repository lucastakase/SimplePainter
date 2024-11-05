public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(4, 4);
        grid.makeGrid();
        Painter painter = new Painter();
        painter.createPainter(grid);
        new MyKeyboardHandler(painter);

    }
}
