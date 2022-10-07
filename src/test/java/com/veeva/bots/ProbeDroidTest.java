package com.veeva.bots;

import com.veeva.area.Plateau;
import com.veeva.area.RectangularPlateau;
import com.veeva.droid.Droid;
import com.veeva.droid.DroidInstruction;
import com.veeva.droid.ProbeDroid;
import com.veeva.position.Direction;
import com.veeva.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProbeDroidTest {

    private Droid droid;
    private Droid boundaryDroid;

    @BeforeEach
    public void init() {
        Plateau plateau = new RectangularPlateau(3,3);
        droid = new ProbeDroid(new Position(1,1, Direction.NORTH), plateau);
        boundaryDroid = new ProbeDroid(new Position(3, 3, Direction.NORTH), plateau);
    }

    @Test
    public void navigateRight() {
        // Given
        List<DroidInstruction> droidInstructions = List.of(DroidInstruction.RIGHT);

        // When
        droid.navigate(droidInstructions);

        // Then
        Position newPosition = droid.getPosition();
        assert newPosition.equals(new Position(1,1, Direction.EAST));
    }

    @Test
    public void navigateLeft() {
        // Given
        List<DroidInstruction> droidInstructions = List.of(DroidInstruction.LEFT);

        // When
        droid.navigate(droidInstructions);

        // Then
        Position newPosition = droid.getPosition();
        assert newPosition.equals(new Position(1,1, Direction.WEST));
    }

    @Test
    public void navigateMove() {
        // Given
        List<DroidInstruction> droidInstructions = List.of(DroidInstruction.MOVE);

        // When
        droid.navigate(droidInstructions);

        // Then
        Position newPosition = droid.getPosition();
        assert newPosition.equals(new Position(1,2, Direction.NORTH));
    }

    @Test
    public void navigateInValidMove() {
        // Given
        List<DroidInstruction> droidInstructions = List.of(DroidInstruction.MOVE);

        // When
        Exception exception = assertThrows(IllegalStateException.class, () -> boundaryDroid.navigate(droidInstructions));

        // Then
        assert exception instanceof IllegalStateException;
        assert exception.getMessage().equals("3 4 N is not a valid move.");
    }
}
