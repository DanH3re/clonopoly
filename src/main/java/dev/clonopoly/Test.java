package dev.clonopoly;

import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;
import dev.clonopoly.ui.DebugWindow;
import dev.clonopoly.utils.Logger;

public class Test {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        System.out.println("Welcome to Clonopoly!");

        // Create players
        Player[] players = new Player[2];
        players[0] = new Player("P1");
        players[1] = new Player("P2");

        // Get game instance and start
        GameLogic game = GameLogic.getInstance(players);

        DebugWindow window = new DebugWindow();
        logger.setDebugWindow(window);
        window.showWindow();

        game.start();
        System.out.println("Game started!");
    }
}