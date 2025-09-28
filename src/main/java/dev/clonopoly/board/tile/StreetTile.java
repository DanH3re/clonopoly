package dev.clonopoly.board.tile;

public class StreetTile extends OwnableTile implements BuildableTile {
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

    @Override
    public String getColorGroup() {
        return "";
    }

    @Override
    public int getHouseCost() {
        return 0;
    }

    @Override
    public int getHotelCost() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void buildHouse() {

    }

    @Override
    public void buildHotel() {

    }
}