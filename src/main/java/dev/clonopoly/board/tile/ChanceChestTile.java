package dev.clonopoly.board.tile;

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

    @Override
    public String toString() {
        return cardType + "Tile";
    }
}