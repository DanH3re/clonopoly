package dev.clonopoly.ui;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.state.inputType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebugWindow {
    Board board = Board.getInstance();
    GameLogic game = GameLogic.getInstance();
    JFrame windowFrame = new JFrame();
    JTextArea logArea = new JTextArea();
    JTextField commandField = new JTextField();

    private JFrame initializeFrame() {
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(1920, 1080);
        windowFrame.setTitle("Clonopoly");
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setLayout(new BorderLayout());
        return windowFrame;
    }

    private JPanel initializeBoard() {
        JPanel boardPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        int size = board.getSize() / 4 + 1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == 0 || row == size - 1 || col == 0 || col == size - 1) {
                    JPanel tile = new JPanel();
                    tile.setBackground(Color.WHITE);
                    tile.setBorder(BorderFactory.createLineBorder(Color.black));
                    gridBagConstraints.gridx = col;
                    gridBagConstraints.gridy = row;
                    gridBagConstraints.fill = GridBagConstraints.BOTH;
                    gridBagConstraints.weightx = 1.0;
                    gridBagConstraints.weighty = 1.0;

                    String tileName = board.tileAt(row, col).toString();
                    JLabel label = new JLabel(tileName);

                    tile.add(label);
                    boardPanel.add(tile, gridBagConstraints);
                }
            }
        }

        boardPanel.setBackground(Color.WHITE);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return boardPanel;
    }

    private JPanel initializeChatPanel() {
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.setPreferredSize(new Dimension(400, 0));

        // Log area (output)
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Command input
        JPanel inputPanel = new JPanel(new BorderLayout());
        commandField.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JButton sendButton = new JButton("Send");

        inputPanel.add(new JLabel("Command: "), BorderLayout.WEST);
        inputPanel.add(commandField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Handle command input
        ActionListener commandListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commandField.getText().trim();
                if (!command.isEmpty()) {
                    processCommand(command);
                    commandField.setText("");
                }
            }
        };

        commandField.addActionListener(commandListener);
        sendButton.addActionListener(commandListener);

        chatPanel.add(scrollPane, BorderLayout.CENTER);
        chatPanel.add(inputPanel, BorderLayout.SOUTH);
        chatPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return chatPanel;
    }

    private void processCommand(String command) {
        logMessage("> " + command);

        switch (command.toLowerCase()) {
            case "roll":
                game.nextTurn(inputType.ROLL_DICE);
                break;

            case "end_turn":
            case "end":
                game.nextTurn(inputType.END_TURN);
                break;

            case "help":
                logMessage("Available commands: roll, end_turn, buy, auction, trade, help");
                break;

            default:
                logMessage("Unknown command: " + command + ". Type 'help' for available commands.");
                break;
        }
    }

    public void logMessage(String message) {
        logArea.append(message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    public DebugWindow() {
        JFrame windowFrame = initializeFrame();
        JPanel boardPanel = initializeBoard();
        JPanel chatPanel = initializeChatPanel();

        windowFrame.add(boardPanel, BorderLayout.CENTER);
        windowFrame.add(chatPanel, BorderLayout.EAST);

        logMessage("Welcome to Clonopoly!");
        logMessage("Type 'help' for available commands.");
    }

    public void showWindow() {
        windowFrame.setVisible(true);
    }

    public void hideWindow() {
        windowFrame.setVisible(false);
    }
}