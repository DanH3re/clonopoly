package dev.clonopoly.card;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Deck {
    Queue<Card> cards;

    public Deck(String jsonFilePath) {
        this.cards = new LinkedList<>();
        // Load cards from JSON file and add to the queue
    }

    public Card drawCard() {
        Card drawnCard = cards.poll();
        cards.offer(drawnCard);
        return drawnCard;
    }

    public void shuffle() {
        // Convert queue to list, shuffle, and convert back to queue
    }
}