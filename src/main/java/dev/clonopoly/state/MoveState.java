package dev.clonopoly.state;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;
import dev.clonopoly.game.Player;

import java.util.Objects;

public class MoveState extends State {
    public MoveState(GameLogic logic) {
        super(logic);
    }

    @Override
    public void nextGameStep(inputType input) {
        if (Objects.requireNonNull(input) == inputType.ROLL_DICE) {
            int diceOne = (int) (Math.random() * 6) + 1;
            int diceTwo = (int) (Math.random() * 6) + 1;

            int moveBy = diceOne + diceTwo;
            System.out.println("You rolled a " + diceOne + " and a " + diceTwo + " for a total of " + moveBy);
            Board board = Board.getInstance();
            Player currentPlayer = gameLogic.getCurrentPlayer();
            board.move(moveBy, currentPlayer);

            if (diceOne != diceTwo) {
                gameLogic.nextPlayer();
            } else {
                System.out.println("Doubles! Roll again!");
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
