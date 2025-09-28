package dev.clonopoly.board.tile;

public abstract class Tile {
    private int id;
    protected String name;
    private int position;

    public Tile() {
        this.name = "Unknown Tile";
    }

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

    public String toString(){ return name; };
}

