package dev.clonopoly.board.tile;

import dev.clonopoly.board.tile.Tile;

public class NoOpTile extends Tile {
    public NoOpTile(String name) {
        this.name = name;
    }

    @Override
    public void onLand() {
        //does nothing when player lands on it
        return;
    }
}