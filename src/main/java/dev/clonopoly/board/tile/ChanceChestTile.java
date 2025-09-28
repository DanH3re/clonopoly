package dev.clonopoly.board.tile;

public class ChanceChestTile extends Tile {
    private final CardType cardType;

    public ChanceChestTile(CardType cardType) {
        this.cardType = cardType;
    }


    public CardType getCardType() {
        return cardType;
    }

    public void onLand() {
        //draw a card from chance or community chest deck
        return;
    }

    @Override
    public String toString() {
        return cardType.toString();
    }
}