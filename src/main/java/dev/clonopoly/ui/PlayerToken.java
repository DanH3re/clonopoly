package dev.clonopoly.ui;

import dev.clonopoly.game.Player;

public class PlayerToken {
    private final Player player;

    public PlayerToken(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
