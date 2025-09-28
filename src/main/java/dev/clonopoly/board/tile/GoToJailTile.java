package dev.clonopoly.board.tile;

public class GoToJailTile extends Tile {
    public GoToJailTile(String name) {
        this.name = name;
    }


    @Override
    public void onLand() {
        // Logic for when a player lands on the "Go to Jail" tile
        // For example, move the player to the Jail tile and set their status to "in jail"
        System.out.println("Player landed on Go to Jail! Go directly to Jail. Do not pass Go, do not collect $200.");
        // player.moveToJail(); // Assuming there's a method to move the player to jail
        return;
    }

}