package dev.clonopoly.game;

import dev.clonopoly.board.Board;
import dev.clonopoly.card.Deck;
import dev.clonopoly.state.InputType;
import dev.clonopoly.state.MoveState;
import dev.clonopoly.state.State;

public class GameLogic {
    private static GameLogic instance;

    private State currentState;
    private Board board;
    private Bank bank;
    private GameRules rules;
    private Player[] players;
    private int doublesCount;
    private Deck communityChest;
    private Deck chance;

    private GameLogic(Player[] players) {
        this.board = new Board();
        this.bank = new Bank();
        this.rules = new GameRules();
        this.players = players;
        this.doublesCount = 0;
        this.communityChest = new Deck("community_chest");
        this.chance = new Deck("chance");
    }

    public static GameLogic getInstance(Player[] players) {
        if (instance == null) {
            instance = new GameLogic(players);
        }
        return instance;
    }

    public void start() {
        this.currentState = new MoveState(this);
    }

    public void nextTurn(InputType Input) {
        currentState.nextGameStep(Input);
    }
}