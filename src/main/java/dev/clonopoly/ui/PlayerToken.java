package dev.clonopoly.ui;

import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayerToken extends JPanel {

    private final Player player;

    public PlayerToken(Player player) {
        this.player = player;
        setOpaque(false);  // Make panel transparent
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getPlayerColor());

        // Draw circle filling the entire panel bounds
        g2d.fillOval(0, 0, getWidth(), getHeight());
    }

    private Color getPlayerColor() {
        // Get player index from GameLogic
        List<Player> players = GameLogic.getInstance().getPlayersList();
        int playerIndex = players.indexOf(player);

        // Predefined color palette
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
                Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.PINK};

        return colors[playerIndex % colors.length];
    }
}