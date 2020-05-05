package userinterface;

import java.awt.*;
import java.util.Random;

public class Snake {
    private int length = 3;

    int x[]; // luu toa do x cua Snake
    int y[]; // luu toa do y cua Snake

    long t1;

    public static int GO_UP = 1;
    public static int GO_DOWN = -1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = -2;

    int vector = Snake.GO_DOWN; // chi huong di dau tien

    public Snake() {
        x = new int[20];
        y = new int[20];

        // toa do con ran ban dau
        x[0] = 5;
        y[0] = 4;

        x[1] = 5;
        y[1] = 3;

        x[1] = 5;
        y[1] = 2;
    }

    public void setVector(int vector) {
        if (this.vector != -vector) {
            this.vector = vector;
        }
    }

    public boolean checkToaDoMoi(int x, int y) {
        for (int i = 0; i < length; i++) {
            if (this.x[i] == x && this.y[i] == y) {
                return true;
            }
        }
        return false;
    }


    public Point layToaDoMoi() {
        Random r = new Random();
        int x, y;
        do {
            x = r.nextInt(19);
            y = r.nextInt(19);
        } while (checkToaDoMoi(x, y));
        return new Point(x, y);
    }

    public void update() {
        if (System.currentTimeMillis() - t1 > 300) {
            {
                if (GameScreen.background[x[0]][y[0]] == 2) {
                    length++;
                    GameScreen.background[x[0]][y[0]] = 0;
                    GameScreen.background[layToaDoMoi().x][layToaDoMoi().y] = 2;
                }

                for (int i = length - 1; i > 0; i--) {
                    x[i] = x[i - 1];
                    y[i] = y[i - 1];
                }

                if (vector == Snake.GO_UP) y[0]--;
                if (vector == Snake.GO_DOWN) y[0]++;
                if (vector == Snake.GO_RIGHT) x[0]++;
                if (vector == Snake.GO_LEFT) x[0]--;

                if (x[0] < 0) x[0] = 19;
                if (x[0] > 19) x[0] = 0;
                if (y[0] < 0) y[0] = 19;
                if (y[0] > 19) y[0] = 0;
            }
            t1 = System.currentTimeMillis();
        }
    }

    public void drawSnake(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 0; i < length; i++) {
            g.fillRect(x[i] * 20 + 1, y[i] * 20 + 1, 18, 18);
        }
    }
}
