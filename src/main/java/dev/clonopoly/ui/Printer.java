package dev.clonopoly.ui;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    static GameLogic gameLogic = GameLogic.getInstance();
    static Board board = Board.getInstance();

    public static void printBoard() {

        List<Player> players = gameLogic.getPlayersList();

        for (int i = 0; i < 40; i++) {
            System.out.printf("[%10s]", board.tileAt(i).toString()); // fixed width for alignment
        }
        System.out.println();

        List<List<Player>> playersOnTile = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            playersOnTile.add(new ArrayList<>());
        }
        for (Player player : players) {
            playersOnTile.get(player.getPosition()).add(player);
        }

        int maxStack = playersOnTile.stream().mapToInt(List::size).max().orElse(0);

        // Print players row by row, aligned under tiles
        for (int row = 0; row < maxStack; row++) {
            for (int i = 0; i < 40; i++) {
                if (playersOnTile.get(i).size() > row) {
                    System.out.printf("[%10s]", playersOnTile.get(i).get(row).getName());
                } else {
                    System.out.printf("%12s", ""); // keep spacing
                }
            }
            System.out.println();
        }
    }
}
