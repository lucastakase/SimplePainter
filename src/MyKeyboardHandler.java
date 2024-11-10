import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboardHandler implements KeyboardHandler { //Handles keyboard events
    private Keyboard keyboard; //Reference to the keyboard object
    private Painter painter; //Reference to the painter object

    public MyKeyboardHandler(Painter painter) { //Constructor, initializes the keyboard handler with a painter reference
        keyboard = new Keyboard(this); //Creates a new keyboard object
        this.painter = painter; //Stores the painter reference
        setKeyboardEvents(); //Sets up event listeners for keyboard keys
    }

    private void setKeyboardEvents() { //Adds event listeners for each key
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent paintBlack = new KeyboardEvent();
        paintBlack.setKey(KeyboardEvent.KEY_Z);
        paintBlack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paintBlack);

        KeyboardEvent erase = new KeyboardEvent();
        erase.setKey(KeyboardEvent.KEY_SPACE);
        erase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(erase);

        KeyboardEvent paintBlue = new KeyboardEvent();
        paintBlue.setKey(KeyboardEvent.KEY_X);
        paintBlue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paintBlue);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clear);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) { //Handles key press events
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            painter.moveLeft();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            painter.moveRight();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            painter.moveUp();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            painter.moveDown();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Z) {
            painter.paintBlack();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            painter.erase();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_X) {
            painter.paintBlue();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            painter.save();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            painter.load();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            painter.clear();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) { //Handles key release events (not used in this case)

    }
}


