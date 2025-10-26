package dev.clonopoly.state;

import dev.clonopoly.game.GameLogic;
import dev.clonopoly.utils.Logger;

public class DecisionState extends State {
    private final boolean canMove;
    private final Logger logger = Logger.getInstance();

    public DecisionState(GameLogic gameLogic, boolean canMove) {
        super(gameLogic);
        this.canMove = canMove;
    }

    @Override
    public void nextGameStep(inputType input) {
       switch (input) {
           case ROLL_DICE:
                if(canMove) {
                    gameLogic.setState(new MoveState(gameLogic));
                } else {
                    logger.logError("Player cannot roll dice again.");
                }

           case BUY_PROPERTY:
                // TODO: implement buy property state
                break;

           case AUCTION_PROPERTY:
                // TODO: implement auction property state
                break;

           case TRADE:
                // TODO: implement trade state
                break;

           case END_TURN:
                gameLogic.nextPlayer();
                gameLogic.setState(new MoveState(gameLogic));
                break;

           default:
               throw new IllegalStateException("Unexpected value: " + input);
       }
    }
}
