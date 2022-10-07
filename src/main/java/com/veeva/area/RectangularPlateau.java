package com.veeva.area;

import com.veeva.position.Position;

import java.util.Objects;

/**
 * This class represents a rectangular searchable area.
 *
 */
public class RectangularPlateau implements Plateau {
    private int x;
    private int y;

    public RectangularPlateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(Position position) {
        return position.getX() <= x && position.getY() <= y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangularPlateau rectangularPlateau = (RectangularPlateau) o;
        return x == rectangularPlateau.x && y == rectangularPlateau.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
