package dev.clonopoly.board.tile;

public class StreetTile extends Tile implements OwnableTile, BuildableTile {
    String name;

    public StreetTile(String name) {
        this.name = name;
    }

    @Override
    public void onLand() {
    // TODO: implement
    }

    @Override
    public String toString() {
        return name;
    }
}