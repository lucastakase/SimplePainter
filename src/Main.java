public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(20, 20);
        Painter painter = new Painter(0, 0, grid);
        new MyKeyboardHandler(painter);

    }
}
