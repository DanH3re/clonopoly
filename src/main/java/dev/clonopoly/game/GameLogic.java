package dev.clonopoly.game;

import dev.clonopoly.datatypes.CyclicIterator;
import dev.clonopoly.state.inputType;
import dev.clonopoly.state.MoveState;
import dev.clonopoly.state.State;

import java.util.List;

public class GameLogic {
    private static GameLogic instance;
    private final CyclicIterator<Player> players;

    private State currentState;
    private Player currentPlayer;

    private GameLogic(Player[] playerArray) {
        this.players = new CyclicIterator<Player>(playerArray);
        this.currentPlayer = players.next();
        GameData.getInstance().setLogic(this);
    }

    public static GameLogic getInstance(Player[] players) {
        if (instance == null) {
            instance = new GameLogic(players);
        }
        return instance;
    }

    public static GameLogic getInstance() {
        if (instance == null) {
            throw new IllegalStateException("GameLogic not initialized. Call getInstance(Player[]) first.");
        }
        return instance;
    }

    // Game flow methods

    public void start() {
        this.currentState = new MoveState(this);
    }
    public void nextTurn(inputType Input) {
        currentState.nextGameStep(Input);
    }
    
    public void nextPlayer() {
        this.currentPlayer = players.next();
    }

    // Getters and Setters
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public List<Player> getPlayersList() {
        return players.toList();
    }

    public void setState(State state) {
        this.currentState = state;
    }
}