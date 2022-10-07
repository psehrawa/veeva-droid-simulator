package com.veeva.position;

import lombok.Getter;

import java.util.Objects;

/**
 * This class represents position of an object in a 2 Dimensional space.
 * Uses x and y co-ordinate system for Location and Direction for Orientation.
 */
@Getter
public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * Method returns new Position after turning right.
     */
    public Position toRight() {
        return new Position(x, y, direction.toRight());
    }

    /**
     * Method returns new Position after turning left.
     */
    public Position toLeft() {
        return new Position(x, y, direction.toLeft());
    }

    /**
     * Method returns new Position after moving a step.
     */
    public Position move() {
        int newX = x, newY = y;
        switch (getDirection()) {
            case NORTH:
                newY = y + 1;
                break;
            case SOUTH:
                newY = y - 1;
                break;
            case EAST:
                newX = x + 1;
                break;
            case WEST:
                newX = x - 1;
                break;
        }
        return new Position(newX, newY, getDirection());
    }

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
