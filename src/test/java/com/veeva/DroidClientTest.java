package com.veeva;

import com.veeva.area.Plateau;
import com.veeva.area.RectangularPlateau;
import com.veeva.droid.Droid;
import com.veeva.droid.DroidInstruction;
import com.veeva.position.Direction;
import com.veeva.position.Position;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DroidClientTest {

    @Test
    public void parsePlateau() {
        // Given
        String data = "3 3";
        Plateau dataPlateau = new RectangularPlateau(3,3);
        // When
        Plateau parsedPlateau = DroidClient.parsePlateau(data);
        // Then
        assert dataPlateau.equals(parsedPlateau);
    }

    @Test
    public void parsePosition() {
        // Given
        String data = "1 1 N";
        Position dataPosition = new Position(1,1, Direction.NORTH);
        // When
        Position parsedPosition = DroidClient.parsePosition(data);
        // Then
        assert dataPosition.equals(parsedPosition);
    }

    @Test
    public void parseInstruction() {
        // Given
        String data = "LMR";

        // When
        List<DroidInstruction> droidInstructions = DroidClient.parseInstructions(data);

        // Then
        assert droidInstructions.get(0) == DroidInstruction.LEFT;
        assert droidInstructions.get(1) == DroidInstruction.MOVE;
        assert droidInstructions.get(2) == DroidInstruction.RIGHT;
    }

    @Test
    public void invalidMovesThrowIllegalStateException() {
        // Given
        String instructions = "3 3 \n 1 2 N \n LMLMLMLMM \n 3 3 E \n MMMMMMMMMMM \n";
        InputStream reader = new ByteArrayInputStream(instructions.getBytes());

        // When
        Exception exception = assertThrows(IllegalStateException.class,
                () -> DroidClient.readAndExecuteCommands(reader));

        // Then
        assert exception.getMessage().equals("4 3 E is not a valid move.");
    }

    @Test
    public void validMoves() {
        // Given
        String instructions = "5 5 \n 1 2 N \n LMLMLMLMM \n 3 3 E \n MMRMMRMRRM \n";
        Position firstDroidPos = new Position(1, 3, Direction.NORTH);
        Position secondDroidPos = new Position(5, 1, Direction.EAST);
        InputStream reader = new ByteArrayInputStream(instructions.getBytes());

        // When
        List<Droid> droids = DroidClient.readAndExecuteCommands(reader);

        // Then
        assert droids.get(0).getPosition().equals(firstDroidPos);
        assert droids.get(1).getPosition().equals(secondDroidPos);
    }

    @Test
    public void invalidString_throwIllegalArgumentException() {
        // Given
        String nullString = null;
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DroidClient.isValidString(null));
        // Then
        assert exception instanceof IllegalArgumentException;
    }

    @Test
    public void validString_isValidString_throwIllegalArgumentException() {
        // Given
        String validString = "Hello";
        // When
        boolean stringValidity = DroidClient.isValidString("Hello");
        // Then
        assert stringValidity;
    }

    @Test
    public void largePlateau() {
        // Given
        String instructions = "100 100 \n 0 0 N \n MMMMMMMMMM \n";
        Position droidPos = new Position(0, 10, Direction.NORTH);
        InputStream reader = new ByteArrayInputStream(instructions.getBytes());

        // When
        List<Droid> droids = DroidClient.readAndExecuteCommands(reader);

        // Then
        assert droids.get(0).getPosition().equals(droidPos);
    }

    @Test
    public void linearPlateau() {
        // Given
        String instructions = "0 10 \n 0 0 N \n MMMMMMMMMM \n";
        Position droidPos = new Position(0, 10, Direction.NORTH);
        InputStream reader = new ByteArrayInputStream(instructions.getBytes());

        // When
        List<Droid> droids = DroidClient.readAndExecuteCommands(reader);

        // Then
        assert droids.get(0).getPosition().equals(droidPos);
    }
}
