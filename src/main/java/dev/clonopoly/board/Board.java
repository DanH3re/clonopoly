package dev.clonopoly.board;

import dev.clonopoly.board.tile.*;
import dev.clonopoly.board.tile.NoOpTile;
import dev.clonopoly.game.Player;

public class Board {
    private final Tile[] tiles;
    private final int size;
    private static Board instance = null;

    private Board() {
        this.tiles = new Tile[40];
        this.size = 40;

        for (int i = 0; i < size; i++) {
            tiles[i] = new NoOpTile("N/A");
        }

        instance = this;
        JSONLoader.getInstance().loadBoard("src/main/resources/board-data.json");
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

    public void addTile(Tile tile, int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        tiles[position] = tile;
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