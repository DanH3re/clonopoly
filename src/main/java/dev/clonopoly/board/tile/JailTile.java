package dev.clonopoly.board.tile;

import dev.clonopoly.board.tile.Tile;
import dev.clonopoly.game.Player;

import java.util.Vector;

public class JailTile extends Tile {

    /*
    public class PlayersInJail {
        Player player;
        int turnsInJail;

        public PlayersInJail(Player player, int turnsInJail) {
            this.player = player;
            this.turnsInJail = turnsInJail;
        }
    }

    Vector<PlayersInJail> playersInJail = new Vector<>();
    */
    @Override
    public void onLand() {
        // Logic for when a player lands on the "Jail" tile
        // For example, just visiting or going to jail
        System.out.println("Player landed on Jail! Just visiting");
        return;
    }
}