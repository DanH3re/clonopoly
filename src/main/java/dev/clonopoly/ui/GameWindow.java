package dev.clonopoly.ui;
import dev.clonopoly.board.Board;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    Board board = Board.getInstance();
    JFrame windowFrame = new JFrame();

    private JFrame initializeFrame() {
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(800,720);
        windowFrame.setTitle("Clonopoly");
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setVisible(true);
        return windowFrame;
    }

    private JPanel initializeBoard() {
        JPanel boardPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if(row == 0 || row == 9 || col == 0 || col == 9) {
                    JPanel tile = new JPanel();
                    tile.setBackground(Color.WHITE);
                    tile.setBorder(BorderFactory.createLineBorder(Color.black));
                    gridBagConstraints.gridx = col;
                    gridBagConstraints.gridy = row;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    gridBagConstraints.weightx = 1.0;
                    gridBagConstraints.weighty = 1.0;

                    JLabel label = new JLabel(board.tileAt(row, col).toString());
                    tile.add(label);
                    boardPanel.add(tile, gridBagConstraints);
                }
            }
        }

        boardPanel.setBackground(Color.WHITE);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        return boardPanel;
    }

    public GameWindow() {
        JFrame windowFrame = initializeFrame();
        JPanel boardPanel = initializeBoard();
        windowFrame.add(boardPanel);
    }

    public void showWindow() {
        windowFrame.setVisible(true);
    }

    public void hideWindow() {
        windowFrame.setVisible(false);
    }
}
