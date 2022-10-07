package com.veeva.position;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {

    /**
     * Map of Valid right directions map.
     * Left is reverse of right.
     */
    Map<Direction, Direction> VALID_RIGHT_DIRECTION = new HashMap<>(){{
        put(Direction.EAST, Direction.SOUTH);
        put(Direction.SOUTH, Direction.WEST);
        put(Direction.WEST, Direction.NORTH);
        put(Direction.NORTH, Direction.EAST);
    }};

    @Test
    public void validParseDirection() {
        // Given
        Map<String, Direction> rawDataToDirections = new HashMap<>(){{
           put("W", Direction.WEST);
           put("E", Direction.EAST);
           put("S", Direction.SOUTH);
           put("N", Direction.NORTH);
        }};

        for(Map.Entry<String, Direction> rawDataToDirection : rawDataToDirections.entrySet()) {
            // When
            Direction parsedDirection = Direction.parseDirection(rawDataToDirection.getKey());
            // Then
            assert parsedDirection == rawDataToDirection.getValue();
        }
    }

    @Test
    public void invalidParseDirection_throwIllegalArgumentException() {
        // Given
        String directionSign = "X";

        // When
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Direction.parseDirection(directionSign));

        // Then
        assert exception instanceof IllegalArgumentException;
        assert exception.getMessage().equals("Illegal direction sign " + directionSign);
    }

    @Test
    public void toRight() {
        // Given VALID_RIGHT_DIRECTION

        for(Map.Entry<Direction, Direction> validRightMove : VALID_RIGHT_DIRECTION.entrySet()) {
            // When
            Direction rightDirection = validRightMove.getKey().toRight();
            // Then
            assert rightDirection == validRightMove.getValue();
        }
    }

    @Test
    public void toLeft() {
        // Given VALID_RIGHT_DIRECTION values can be used as keys and vice versa for left directions

        for(Map.Entry<Direction, Direction> validRightMove : VALID_RIGHT_DIRECTION.entrySet()) {
            // When
            Direction leftDirection = validRightMove.getValue().toLeft();
            // Then
            assert leftDirection == validRightMove.getKey();
        }
    }
}
