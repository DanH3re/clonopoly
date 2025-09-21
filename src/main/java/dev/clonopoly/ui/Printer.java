package dev.clonopoly.ui;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;
import java.util.List;

public class Printer {
    GameLogic gameLogic = GameLogic.getInstance();
    Board board = Board.getInstance();

    public static void printBoard() {
        String[][] boardString = new String[13][13];
        List<Player> players = gameLogic.getPlayers().getAllItems();

        //TODO: improve printing when there are multiple players on the same tile
        for(int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                // corner, nothing printed here
                if ((i == 0 && j == 0) || (i == 0 && j == 12) || (i == 12 && j == 12) || (i == 12 && j == 0)) {
                    boardString[i][j] = " ";
                }

                //lateral row/column which will hold information about the player position
                else if (i == 0 || i == 12 || j == 0 || j == 12) {
                    boardString[i][j] = "P";
                }
                //here I will print the tiles
                else if (i == 1 || i == 11 || j == 1 || j == 11) {
                    boardString[i][j] = "T";
                }
                //inside of the board, nothing printed here
                else {
                    boardString[i][j] = " ";
                }
            }
        }

        for(int i = 0; i < 13; i++) {
            for(int j = 0; j < 13; j++) {
                System.out.print(boardString[i][j] + " ");
            }
            System.out.println();
        }
    }
}
