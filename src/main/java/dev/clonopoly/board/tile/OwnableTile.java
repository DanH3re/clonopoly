package dev.clonopoly.board.tile;

public abstract class OwnableTile extends Tile {
    // Mutable properties
    int id;
    String owner;
    int price;
    boolean isMortgaged;

    // Immutable properties
    String name;
    int cost;
    int[] rent;
}