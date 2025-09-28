package dev.clonopoly.board;

import dev.clonopoly.board.tile.*;
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

        tiles[0] = new GoTile();
        tiles[10] = new JailTile();
        tiles[20] = new NoOpTile();
        tiles[30] = new GoToJailTile();
        //TODO: initialize the tiles with actual game tiles
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public Tile tileAt(int row, int col) {
        int MAX_ROW = size / 4;

        int tileNo;

        if (row == MAX_ROW) {
            tileNo = MAX_ROW - col;
        } else if (col == 0) {
            tileNo = MAX_ROW + (MAX_ROW - row);
        } else if (row == 0) {
            tileNo = MAX_ROW*2 + col;
        } else if (col == MAX_ROW) {
            tileNo = MAX_ROW*3 + row;
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

    public int getSize() {
        return size;
    }

    public void move(int tilesToMove, Player player) {
        int oldPos; int newPos;

        oldPos = player.getPosition();
        newPos = (oldPos + tilesToMove) % size;
        player.setPosition(newPos);
    }
}