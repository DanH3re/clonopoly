package dev.clonopoly.ui;
import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DebugWindow {
    Board board = Board.getInstance();
    JFrame windowFrame = new JFrame();
    GameLogic game = GameLogic.getInstance();
    List<Player> players = game.getPlayersList();

    private JFrame initializeFrame() {
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(1920,1080);
        windowFrame.setTitle("Clonopoly");
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setVisible(true);
        return windowFrame;
    }

    private JPanel initializeBoard() {
        JPanel boardPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        int size = board.getSize() / 4 + 1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(row == 0 || row == size - 1 || col == 0 || col == size - 1) {
                    JPanel tile = new JPanel();
                    tile.setBackground(Color.WHITE);
                    tile.setBorder(BorderFactory.createLineBorder(Color.black));
                    gridBagConstraints.gridx = col;
                    gridBagConstraints.gridy = row;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    gridBagConstraints.weightx = 1.0;
                    gridBagConstraints.weighty = 1.0;

                    String tileName= board.tileAt(row, col).toString();
                    JLabel label = new JLabel(tileName);

                    tile.add(label);
                    boardPanel.add(tile, gridBagConstraints);
                }
            }
        }

        boardPanel.setBackground(Color.WHITE);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        return boardPanel;
    }

    public DebugWindow() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));

        JPanel boardPanel = initializeBoard();
        boardPanel.setBounds(0, 0, 800, 600);

        PlayerToken p1 = new PlayerToken(players.get(0));
        p1.setBounds(100, 100, 20, 20);

        PlayerToken p2 = new PlayerToken(players.get(1));
        p2.setBounds(150, 150, 20, 20);

        layeredPane.add(boardPanel, Integer.valueOf(0)); // background
        layeredPane.add(p1, Integer.valueOf(1));         // on top
        layeredPane.add(p2, Integer.valueOf(1));         // on top

        windowFrame.add(layeredPane);
        windowFrame.pack();
        windowFrame.setVisible(true);
    }

    public void showWindow() {
        windowFrame.setVisible(true);
    }

    public void hideWindow() {
        windowFrame.setVisible(false);
    }
}
