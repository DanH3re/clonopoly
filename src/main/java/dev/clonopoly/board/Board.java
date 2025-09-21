package dev.clonopoly.board;

import dev.clonopoly.board.tile.Tile;

public class Board {
    private final Tile[] tiles;
    private final int size;

    public Board() {
        this.tiles = new Tile[40];
        this.size = 40;
    };

    public Tile tileAt(int pos) {
        return tiles[pos];
    };

    public Tile nearestAfter(int from, Tile target) {
        //not implemented, always returns the first tile
        return tiles[0];
    };

    public void goTo(int pos) {
        //moves the player to the specified position
    };

    public void move(int tilesToMove) {
        //moves the player by a no of positions
    }
};