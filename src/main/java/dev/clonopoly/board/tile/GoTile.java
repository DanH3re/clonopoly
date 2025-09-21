package dev.clonopoly.board.tile;

import dev.clonopoly.board.tile.Tile;

public class GoTile extends Tile {

    public GoTile() {
        // Constructor logic if needed
    }

    @Override
    public void onLand() {
        // Logic for when a player lands on the "Go" tile
        // For example, give the player $200
        System.out.println("Player landed on Go! Collect $200.");
        // player.addMoney(200); // Assuming there's a method to add money to the player
        return;
    }
}