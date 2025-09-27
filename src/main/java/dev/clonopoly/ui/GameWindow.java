package dev.clonopoly.ui;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameWindow {
    JFrame frame = new JFrame();
    JPanel panelBoard = new JPanel(null);
    GridLayout gridLayout = new GridLayout(10,10);

    public GameWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,720);
        frame.setTitle("Clonopoly");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panelBoard.setBackground(Color.WHITE);
        panelBoard.setLayout(gridLayout);
        //crate 100 more panels to create the board
        for(int i = 0; i < 100; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createLineBorder(Color.black));
            panelBoard.add(panel);
        }

        frame.add(panelBoard);
    }
}
