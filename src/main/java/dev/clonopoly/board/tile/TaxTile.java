package dev.clonopoly.board.tile;

public class TaxTile extends Tile {
    private final int taxAmount;

    public TaxTile(String name) {
        this.name = name;
        if (name.equals("Income Tax")) {
            this.taxAmount = 200;
        } else if (name.equals("Luxury Tax")) {
            this.taxAmount = 100;
        } else {
            throw new IllegalArgumentException("Invalid tax tile name");
        }
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

    @Override
    public String toString() {
        return "Tax" + taxAmount;
    }
}