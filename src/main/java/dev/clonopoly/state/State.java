package dev.clonopoly.state;

import dev.clonopoly.game.GameLogic;

public abstract class State {
    GameLogic gameLogic;

    protected State(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public abstract void nextGameStep(InputType input);


}