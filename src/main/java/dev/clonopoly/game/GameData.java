package dev.clonopoly.game;

import dev.clonopoly.board.Board;
import dev.clonopoly.card.Deck;
import dev.clonopoly.datatypes.CyclicIterator;

public class GameData {
    private GameLogic logic;
    private static GameData instance;
    private Bank bank;
    private GameRules rules;
    private CyclicIterator<Player> players;
    private int doublesCount;
    private Deck communityChest;
    private Deck chance;

    private GameData() {
        this.doublesCount = 0;
        this.bank = new Bank();
        this.rules = new GameRules();
        this.communityChest = new Deck("community_chest");
        this.chance = new Deck("chance");
    }

    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
        return instance;
    }
}
