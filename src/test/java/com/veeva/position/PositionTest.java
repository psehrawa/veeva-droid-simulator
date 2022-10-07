package com.veeva.position;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PositionTest {

    private static Map<Position, Position> VALID_RIGHT_POSITIONS;
    private static Map<Position, Position> VALID_MOVE_POSITIONS;

    @BeforeAll
    public static void init() {
        VALID_RIGHT_POSITIONS = new HashMap<>();
        VALID_MOVE_POSITIONS = new HashMap<>();
        int x = 1;
        int y = 1;
        for(Direction direction : Direction.values()) {
            VALID_RIGHT_POSITIONS.put(new Position(x, y, direction), new Position(x, y, direction.toRight()));
        }
        VALID_MOVE_POSITIONS.put(new Position(x, y, Direction.NORTH), new Position(x, y+1, Direction.NORTH));
        VALID_MOVE_POSITIONS.put(new Position(x, y, Direction.SOUTH), new Position(x, y-1, Direction.SOUTH));
        VALID_MOVE_POSITIONS.put(new Position(x, y, Direction.WEST), new Position(x-1, y, Direction.WEST));
        VALID_MOVE_POSITIONS.put(new Position(x, y, Direction.EAST), new Position(x+1, y, Direction.EAST));
    }

    @Test
    public void toRight() {
        // Given VALID_RIGHT_POSITIONS

        for(Map.Entry<Position, Position> validRightPosition: VALID_RIGHT_POSITIONS.entrySet()) {
            // When
            Position rightPosition = validRightPosition.getKey().toRight();

            // Then
            assert rightPosition.equals(validRightPosition.getValue());
        }
    }

    @Test
    public void toLeft() {
        // Given VALID_RIGHT_POSITIONS reversed data are valid left positions

        for(Map.Entry<Position, Position> validRightPosition: VALID_RIGHT_POSITIONS.entrySet()) {
            // When
            Position leftPosition = validRightPosition.getValue().toLeft();

            // Then
            assert leftPosition.equals(validRightPosition.getKey());
        }
    }
    
    @Test
    public void move() {
        // Given VALID_MOVE_POSITIONS

        for(Map.Entry<Position, Position> validMovePosition: VALID_MOVE_POSITIONS.entrySet()) {
            // When
            Position movePosition = validMovePosition.getKey().move();

            // Then
            assert movePosition.equals(validMovePosition.getValue());
        }
    }

    @Test
    public void toStringFormat() {
        // Given
        Position position = new Position(1,1,Direction.NORTH);

        // When
        String toStringResponse = position.toString();

        // Then
        assert toStringResponse.equals("1 1 N");
    }

}
