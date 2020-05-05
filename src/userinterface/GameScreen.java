package userinterface;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements Runnable {
    Thread thread;

    static int background[][] = new int[20][20];

    Snake snake;

    public GameScreen() {
        snake = new Snake();

        background[10][10] = 2;

        thread = new Thread(this);
        thread.start();
    }

    public void paintBackGround(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                g.fillRect(i * 20 + 1, j * 20 + 1, 18, 18);
                if(background[i][j] == 2){
                    g.setColor(Color.YELLOW);
                    g.fillRect(i * 20 + 1, j * 20 + 1, 18, 18);
                    g.setColor(Color.GRAY);
                }
            }
        }
    }

    public void paint(Graphics g) {
        paintBackGround(g);
        snake.drawSnake(g);
    }

    @Override
    public void run() {
        while (true) {
            snake.update();
            repaint();
            try {
                thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
    }
}