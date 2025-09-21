package dev.clonopoly.board.tile;

import dev.clonopoly.board.tile.Tile;

public class NoOpTile extends Tile {
    @Override
    public void onLand() {
        //does nothing when player lands on it
        return;
    }

    @Override
    public String toString() {
        return "NOP";
    }
}