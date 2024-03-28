package org.example.data;

import javax.swing.*;
import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Ball(int x, int y, int width, int height, String url) {
        this.x = x;
        this.y = y;


        ImageIcon ii = new ImageIcon(getClass().getResource("/"+ url));

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();

        this.image = ii.getImage();
    }

    private Rectangle getBallRectangle(){
        return new Rectangle(x,y,width, height);
    }

    public boolean isColided(Rectangle otherObject){
        return getBallRectangle().intersects(otherObject);
    }

    public void move(int steps, Direction direction) {
        switch (direction) {
            case DOWN -> {
                y += steps;
            }
            case UP -> {
                y -= steps;
            }
            case LEFT -> {
                x -= steps;
            }
            case RIGHT -> {
                x += steps;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
