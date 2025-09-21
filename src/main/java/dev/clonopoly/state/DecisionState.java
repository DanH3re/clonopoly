package dev.clonopoly.state;

import dev.clonopoly.game.GameLogic;

public class DecisionState extends State {
    public DecisionState(GameLogic gameLogic) {super(gameLogic);}

    @Override
    public void nextGameStep(inputType input) {
       switch (input) {
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

       }
    }
}
