package dev.clonopoly.board.tile;

public abstract class Tile {
    private int id;
    private int position;
    private int[] playersOnTile;

    public void onLand() {
        
    };

    public int getId() {
        return id;
    };

    public int getPosition() {
        return position;
    };

    public int getNoPlayersOnTile() {
        return 0;
    };

    public String toString(){ return "Tile"; };
}

