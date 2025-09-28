package dev.clonopoly.board.tile;

public interface BuildableTile {
    String getColorGroup();
    int getHouseCost();
    int getHotelCost();
    int getLevel();
    void buildHouse();
    void buildHotel();
}