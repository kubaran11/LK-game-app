package org.example;

import org.example.data.Ball;
import org.example.data.Direction;
import org.example.data.Wall;


import java.awt.*;
import java.util.ArrayList;

public class GameData {
    private Ball ball;
    private ArrayList<Wall> walls;

    public GameData() {
        walls = new ArrayList<>();
    }

    public void update() {
        ball.move(5, Direction.RIGHT);
        for (Wall wall: walls) {
            if (ball.isColided(wall.getRectangle())){
                wall.inactive();
            }
        }
    }

    public void initialize() {
        ball = new Ball(20, 20, 50, 50, "cerveny_player.png");

        Wall wall1 = new Wall(250, 30, 250, 80, Color.BLACK);
        Wall wall2 = new Wall(400, 70, 500, 70, Color.BLACK);
        Wall wall3 = new Wall(350, 60, 350, 120, Color.BLACK);
        Wall wall4 = new Wall(150, 330, 150, 380, Color.BLACK);
        walls.add(wall1);
        walls.add(wall2);
        walls.add(wall3);
        walls.add(wall4);
    }

    public Ball getBall() {
        return ball;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }
}
