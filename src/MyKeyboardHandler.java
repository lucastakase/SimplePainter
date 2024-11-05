import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class MyKeyboardHandler implements KeyboardHandler {
    private Keyboard keyboard;
    private Painter painter;

    public MyKeyboardHandler(Painter painter) {
        keyboard = new Keyboard(this);
        this.painter = painter;
        setKeyboardEvents();
    }

        private void setKeyboardEvents() {
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
        public void keyPressed(KeyboardEvent keyboardEvent){
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
                try {
                    painter.save();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
                painter.load();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT && keyboardEvent.getKey() == KeyboardEvent.KEY_Z) {
                painter.paintBlack();
                painter.moveLeft();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT && keyboardEvent.getKey()== KeyboardEvent.KEY_Z) {
                painter.moveRight();
                painter.paintBlack();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP && keyboardEvent.getKey() == KeyboardEvent.KEY_Z) {
                painter.moveUp();
                painter.paintBlack();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN && keyboardEvent.getKey() == KeyboardEvent.KEY_Z) {
                painter.moveDown();
                painter.paintBlack();
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
                painter.clear();
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent){

        }
    }


