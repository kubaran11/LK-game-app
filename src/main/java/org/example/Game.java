package org.example;

import org.example.data.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    GameData data;
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        data = new GameData();
        GameGraphics graphics = new GameGraphics();

        data.initialize();
        graphics.render(data);

        graphics.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    data.getBall().move(50, Direction.LEFT);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        Timer timer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                data.update();
                graphics.render(data);
            }
        });

        timer.start();

    }
}
