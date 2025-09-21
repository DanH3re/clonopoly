package dev.clonopoly.board.tile;

import dev.clonopoly.board.tile.Tile;
import dev.clonopoly.board.tile.cardType;

public class ChanceChestTile extends Tile {
    private final cardType cardType;

    public ChanceChestTile(cardType cardType) {
        this.cardType = cardType;
    }

    public cardType getCardType() {
        return cardType;
    }

    public void onLand() {
        //draw a card from chance or community chest deck
        return;
    }
}