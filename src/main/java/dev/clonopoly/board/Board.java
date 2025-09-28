package dev.clonopoly.board;

import dev.clonopoly.board.tile.NoOpTile;
import dev.clonopoly.board.tile.Tile;
import dev.clonopoly.board.tile.NoOpTile;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;
import java.util.List;

public class Board {
    private final Tile[] tiles;
    private final int size;
    private static Board instance = null;

    private Board() {
        this.tiles = new Tile[40];
        this.size = 40;

        //TODO: initialize the tiles with actual game tiles
        for(int i = 0; i < size; i++) {
            tiles[i] = new NoOpTile();
        }
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public Tile tileAt(int row, int col) {
        int tileNo;

        if (row == 9) {
            tileNo = 9 - col;
        } else if (col == 0) {
            tileNo = 9 + (9 - row);
        } else if (row == 0) {
            tileNo = 18 + col;
        } else if (col == 9) {
            tileNo = 27 + row;
        } else {
            tileNo = -1;
        }

        return tiles[tileNo];
    }

    public Tile nearestAfter(int from, Tile target) {
        // TODO: not implemented, always returns the first/start tile
        return tiles[0];
    }

    public void goTo(int pos, Player player) {
        // TODO: moves the player to the specified position
    }

    public void move(int tilesToMove, Player player) {
        int oldPos; int newPos;

        oldPos = player.getPosition();
        newPos = (oldPos + tilesToMove) % size;
        player.setPosition(newPos);
    }
}