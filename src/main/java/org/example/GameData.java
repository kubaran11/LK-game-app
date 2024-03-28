package org.example;

import org.example.data.Ball;
import org.example.data.Direction;


import java.awt.*;

public class GameData {
    private Ball ball;

    public void update() {
        ball.move(5, Direction.RIGHT);
    }

    public void initialize() {
        ball = new Ball(20, 20, 50, 50, Color.RED);
    }

    public Ball getBall() {
        return ball;
    }
}
