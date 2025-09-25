package dev.clonopoly.ui;
import javax.swing.*;

public class GameWindow {
    JFrame frame = new JFrame();
    JPanel board = new JPanel();

    public GameWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
