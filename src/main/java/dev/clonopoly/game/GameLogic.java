package dev.clonopoly.game;

import dev.clonopoly.board.Board;
import dev.clonopoly.datatypes.CyclicIterator;
import dev.clonopoly.state.inputType;
import dev.clonopoly.state.MoveState;
import dev.clonopoly.state.State;
import dev.clonopoly.ui.Printer;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private static GameLogic instance;
    private static Board board;
    private static GameData gameData;
    private CyclicIterator<Player> players;

    private State currentState;
    private Player currentPlayer;

    private GameLogic(Player[] playerArray) {
        this.players = new CyclicIterator<Player>(playerArray);
        this.board = Board.getInstance();
        this.gameData = GameData.getInstance();
        this.currentPlayer = players.next();
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
    public CyclicIterator<Player> getPlayers() {
        return players;
    }
}