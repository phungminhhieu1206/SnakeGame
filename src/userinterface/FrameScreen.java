package userinterface;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameScreen extends JFrame {
    GameScreen gameScreen;

    public FrameScreen() {
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameScreen = new GameScreen();
        this.add(gameScreen);

        this.addKeyListener(new handler());
        setVisible(true);
    }

    public static void main(String[] args) {
        FrameScreen f = new FrameScreen();
    }

    private class handler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                gameScreen.snake.setVector(Snake.GO_UP);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                gameScreen.snake.setVector(Snake.GO_DOWN);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                gameScreen.snake.setVector(Snake.GO_RIGHT);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                gameScreen.snake.setVector(Snake.GO_LEFT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}