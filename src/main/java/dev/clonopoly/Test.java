package dev.clonopoly;

import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;

public class Test {
    public static void main(String[] args) {
        System.out.println("Welcome to Clonopoly!");

        // Create players (you'll need to implement Player class)
        Player[] players = new Player[2]; // Example with 2 players
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");

        // Get game instance and start
        GameLogic game = GameLogic.getInstance(players);
        game.start();

        System.out.println("Game started!");
    }
}