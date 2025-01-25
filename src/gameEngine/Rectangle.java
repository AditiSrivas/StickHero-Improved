package gameEngine;
/*
import java.util.Random;
*/
/**
 * Created by yashardabiran on 6/29/15.
 */
/*
public class Rectangle {
    public static final int MIN_SIZE = 50;
    public static final int MAX_SIZE = 120;
    private int width;

    public Rectangle() {
        Random rand = new Random();

        width = 0;
        while (width < Rectangle.MIN_SIZE)
            width = rand.nextInt(Rectangle.MAX_SIZE);
    }

    public int getWidth() {
        return width;
    }
}
*/

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class GameRectangle {
    public static final int MIN_SIZE = 50;
    public static final int MAX_SIZE = 120;

    private Rectangle rectangle;

    public GameRectangle() {
        Random rand = new Random();

        double width = 0;
        while (width < GameRectangle.MIN_SIZE)
            width = rand.nextInt(GameRectangle.MAX_SIZE);

        rectangle = new Rectangle(width, width);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public double getWidth() {
        return rectangle.getWidth();
    }
}
