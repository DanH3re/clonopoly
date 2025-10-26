package dev.clonopoly.state;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;
import dev.clonopoly.ui.DebugWindow;

import java.util.Objects;

public class MoveState extends State {
    public MoveState(GameLogic logic) {
        super(logic);
    }

    // Temporary, before observer pattern is implemented
    DebugWindow window = DebugWindow.getInstance();

    @Override
    public void nextGameStep(inputType input) {
        if (Objects.requireNonNull(input) == inputType.ROLL_DICE) {
            int diceOne = (int) (Math.random() * 6) + 1;
            int diceTwo = (int) (Math.random() * 6) + 1;

            int moveBy = diceOne + diceTwo;
            Board board = Board.getInstance();
            Player currentPlayer = gameLogic.getCurrentPlayer();
            board.move(moveBy, currentPlayer);

            // Temporary, before observer pattern is implemented
            window.updateTokenPosition(currentPlayer);

            if (diceOne != diceTwo) {
                gameLogic.setState(new DecisionState(gameLogic));
            } else {
                gameLogic.nextTurn(inputType.ROLL_DICE);
            }
        }
        else {
            throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
