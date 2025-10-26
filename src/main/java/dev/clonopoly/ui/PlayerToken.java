package dev.clonopoly.ui;

import dev.clonopoly.game.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerToken extends JPanel {

    private final Player player;

    public PlayerToken(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Convert to Graphics2D for better quality and control
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color of the circle
        g2d.setColor(Color.RED);

        // Draw a small circle at position (50, 50) with diameter 20
        int x = 50;
        int y = 50;
        int diameter = 20;
        g2d.fillOval(x, y, diameter, diameter); // use drawOval if you want only the outline
    }

}
