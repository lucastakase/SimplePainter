public class Main2 {
    public static void main(String[] args) {
        Grid grid = new Grid(50, 50);
        grid.makeGrid();
        Painter painter = new Painter();
        painter.createPainter(grid);
        new MyKeyboardHandler(painter);

    }
}
