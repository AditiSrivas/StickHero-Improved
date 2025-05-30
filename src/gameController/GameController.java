package gameController;
/*
import gameEngine.GameEngine;
import gamePanel.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
*/
/**
 * Created by yashardabiran on 6/29/15.
 */
/*
public class GameController implements MouseListener, ActionListener{
    public static final int FPS = 100;
    private GameEngine engine;
    private GamePanel panel;
    private boolean isIncreasing;
    private boolean isRunning;
    public boolean upsideDown;

    public void init(GameEngine engine, GamePanel panel) {
        this.engine = engine;
        this.panel = panel;
    }

    public void start() {
        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                while (isRunning) {
                    panel.repaint();
                    try {
                        Thread.sleep(1000 / GameController.FPS);
                    } catch (Exception e) {

                    }
                }
            }
        });

        gameLoop.start();
    }


    public void nextRect(boolean isMushroomEeten) {
        if (isMushroomEeten)
            engine.mushroomEaten();
        engine.nextRectangle();
    }

    public void gameOver() {
        panel.gameOver();
    }

    public void replay() {
        engine.init();
        panel.replay(engine, this);
    }


    public boolean isUpsideDown() {
        return upsideDown;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        upsideDown = !upsideDown;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (engine.isMoving()) {
            return;
        }

        Thread increaseStick = new Thread(new Runnable() {
            @Override
            public void run() {
                isIncreasing = true;
                while (isIncreasing) {
                    engine.increaseStickLength();
                    try {
                        Thread.sleep(1000 / GameController.FPS);
                    } catch (Exception e) {

                    }
                }
            }
        });

        increaseStick.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isIncreasing = false;
        engine.setMoving(true);
        engine.checkForGameOver();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.goToGame();
    }
}
*/

import gameEngine.GameEngine;
        import gamePanel.GamePanel;
        import javafx.animation.AnimationTimer;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.input.MouseEvent;

public class GameController implements EventHandler<ActionEvent> {
    public static final int FPS = 60; // Adjusted frame rate for JavaFX AnimationTimer
    private GameEngine engine;
    private GamePanel panel;
    private boolean isIncreasing;
    private boolean isRunning;
    public boolean upsideDown;

    public void init(GameEngine engine, GamePanel panel) {
        this.engine = engine;
        this.panel = panel;
    }

    public void start() {
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                panel.repaint();
            }
        };

        gameLoop.start();
    }

    public void nextRect(boolean isMushroomEaten) {
        if (isMushroomEaten)
            engine.mushroomEaten();
        engine.nextRectangle();
    }

    public void gameOver() {
        panel.gameOver();
    }

    public void replay() {
        engine.init();
        panel.replay(engine, this);
    }

    public boolean isUpsideDown() {
        return upsideDown;
    }

    @Override
    public void handle(ActionEvent event) {
        panel.goToGame();
    }

    public void handleMouseClick(MouseEvent event) {
        upsideDown = !upsideDown;
    }

    public void handleMousePress(MouseEvent event) {
        if (engine.isMoving()) {
            return;
        }

        AnimationTimer increaseStickTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                engine.increaseStickLength();
            }
        };

        increaseStickTimer.start();
    }

    public void handleMouseRelease(MouseEvent event) {
        isIncreasing = false;
        engine.setMoving(true);
        engine.checkForGameOver();
    }
}
