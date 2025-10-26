package dev.clonopoly.state;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;
import dev.clonopoly.utils.Logger;

import java.util.Objects;

public class MoveState extends State {
    Logger logger = Logger.getInstance();

    public MoveState(GameLogic logic) {
        super(logic);
    }

    @Override
    public void nextGameStep(inputType input) {
        if (Objects.requireNonNull(input) == inputType.ROLL_DICE) {
            int diceOne = (int) (Math.random() * 6) + 1;
            int diceTwo = (int) (Math.random() * 6) + 1;

            int moveBy = diceOne + diceTwo;

            logger.logInfo("Player rolled " + diceOne + " and " + diceTwo);
            logger.logInfo("Player moves by: " + moveBy);

            Board board = Board.getInstance();
            Player currentPlayer = gameLogic.getCurrentPlayer();
            board.move(moveBy, currentPlayer);

            if (diceOne != diceTwo) {
                gameLogic.setState(new DecisionState(gameLogic, false));
            } else {
                gameLogic.setState(new DecisionState(gameLogic, true));
            }
        }
        else {
            throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
