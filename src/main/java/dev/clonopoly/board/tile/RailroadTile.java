package dev.clonopoly.board.tile;

public class RailroadTile extends OwnableTile {
    public RailroadTile(String name) {
        this.name = name;
    }


    @Override
    public void onLand() {

    }

    @Override
    public String toString() {
        return name;
    }
}