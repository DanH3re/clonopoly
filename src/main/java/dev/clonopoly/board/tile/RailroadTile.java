package dev.clonopoly.board.tile;

public class RailroadTile extends Tile implements OwnableTile {
    String name;

    @Override
    public void onLand() {

    }

    @Override
    public String toString() {
        return name;
    }
}