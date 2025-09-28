package dev.clonopoly;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;
import dev.clonopoly.state.inputType;
import dev.clonopoly.ui.GameWindow;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Clonopoly!");

        // Create players
        Player[] players = new Player[2];
        players[0] = new Player("P1");
        players[1] = new Player("P2");

        // Get game instance and start
        GameLogic game = GameLogic.getInstance(players);
        Board board = Board.getInstance();
        game.start();

        System.out.println("Game started!");

        GameWindow window = new GameWindow();
        window.showWindow();

        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("\nCurrent player: " + game.getCurrentPlayer().getName());

            System.out.print("Enter command (roll/quit/end_turn): ");
            String input = scanner.nextLine().toLowerCase().trim();

            switch (input) {
                case "roll":
                    game.nextTurn(inputType.ROLL_DICE);
                    break;

               case "end_turn":
                    game.nextTurn(inputType.END_TURN);
                    break;

                case "quit":
                    gameRunning = false;
                    System.out.println("Thanks for playing!");
                    break;

                default:
                    System.out.println("Invalid command. Try: roll, end_turn, or quit");
                    break;
            }

        }

        scanner.close();
    }
}