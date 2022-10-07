package com.veeva.position;

import lombok.Getter;

/**
 * This enum represents four cardinal direction.
 */
@Getter
public enum Direction {

    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private Character direction;

    Direction(Character directionChar) {
        this.direction = directionChar;
    }

    /**
     * This method parses the Direction given the direction data in string.
     * Throws IllegalArgumentException for unrecognised direction.
     */
    public static Direction parseDirection(String direction) {
        switch (direction) {
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "E":
                return EAST;
            case "W":
                return WEST;
        }
        throw new IllegalArgumentException("Illegal direction sign " + direction);
    }

    /**
     * Method returns change in direction after a 90-degree right rotation.
     */
    public Direction toRight() {
        if(this == NORTH) {
            return EAST;
        } else if(this == SOUTH) {
            return WEST;
        } else if(this == EAST) {
            return SOUTH;
        } else {
            return NORTH;
        }
    }

    /**
     * Method returns change in direction after a 90-degree left rotation.
     */
    public Direction toLeft() {
        if(this == NORTH) {
            return WEST;
        } else if(this == SOUTH) {
            return EAST;
        } else if(this == EAST) {
            return NORTH;
        } else {
            return SOUTH;
        }
    }

    @Override
    public String toString() {
        return getDirection().toString();
    }
}
