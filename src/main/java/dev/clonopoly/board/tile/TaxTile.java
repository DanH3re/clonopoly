package dev.clonopoly.board.tile;

import dev.clonopoly.board.tile.Tile;

public class TaxTile extends Tile {
    private final int taxAmount;

    public TaxTile(int taxAmount) {
        this.taxAmount = taxAmount;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    @Override
    public void onLand() {
        // Logic for when a player lands on a tax tile
        // For example, deduct the tax amount from the player's money
        System.out.println("Player landed on a Tax Tile! Pay $" + taxAmount + ".");
        // player.deductMoney(taxAmount); // Assuming there's a method to deduct money from the player
        return;
    }
}