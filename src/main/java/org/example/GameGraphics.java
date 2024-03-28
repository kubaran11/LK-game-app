package org.example;

import org.example.data.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GameGraphics extends JFrame {
    GameData data;

    public GameGraphics() throws HeadlessException {
        Draw draw = new Draw();
        add(draw);

        this.data = null;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080,720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(GameData data) {
        this.data = data;
        repaint();
    }

    class Draw extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            if (data != null) {
                g.drawImage(data.getBall().getImage(), data.getBall().getX(), data.getBall().getY(), new ImageObserver() {
                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return false;
                    }
                });

                for (Wall wall: data.getWalls()){
                    if (wall.isActive()) {
                        g.setColor(wall.getColor());
                        g.drawLine(wall.getCoordStart().x,wall.getCoordStart().y, wall.getCoordEnd().x, wall.getCoordEnd().y);
                    }

                }
            }

        }
    }

}
