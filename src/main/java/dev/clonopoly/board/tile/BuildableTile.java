package dev.clonopoly.board.tile;

public interface BuildableTile {
    private int houseCost;
    private int hotelCost;
    private int level;
    String colorGroup;

    public BuildableTile(int houseCost, int hotelCost) {
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
        this.level = 0;
    }

    // Getters
    public int getHouseCost() {
        return houseCost;
    }

    public int getHotelCost() {
        return hotelCost;
    }

    public int getLevel() {
        return level;
    }

    // Methods

    public void buildHouse() {
        if (level < 4) {
            level++;
        } else {
            throw new IllegalStateException("Cannot build more than 4 houses. Consider building a hotel.");
        }
    }

    public void buildHotel() {
        if (level == 4) {
            level = 5; // 5 represents a hotel
        } else {
            throw new IllegalStateException("Need 4 houses to build a hotel.");
        }
    }
}
