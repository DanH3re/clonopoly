package dev.clonopoly.state;

import dev.clonopoly.board.Board;
import dev.clonopoly.game.GameLogic;

import java.util.Objects;

public class MoveState extends State {
    public MoveState(GameLogic logic) {
        super(logic);
    }

    @Override
    public void nextGameStep(InputType input) {
        if (Objects.requireNonNull(input) == InputType.ROLL_DICE) {
            // TODO: dice roll logic
        } else {
            throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
