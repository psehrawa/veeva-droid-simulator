package com.veeva.area;

import com.veeva.position.Direction;
import com.veeva.position.Position;
import org.junit.jupiter.api.Test;

public class RectangularPlateauTest {

    private RectangularPlateau rectangular3by3Plateau = new RectangularPlateau(3,3);

    @Test
    public void valid_isValidMove() {
        // Given
        Position validBasePosition = new Position(0,0, Direction.NORTH);
        Position validBoundaryPosition = new Position(3,3, Direction.NORTH);

        // When
        boolean validBasePositionValidity = rectangular3by3Plateau.isValidMove(validBasePosition);
        boolean validBoundaryPositionValidity = rectangular3by3Plateau.isValidMove(validBoundaryPosition);

        // Then
        assert true == validBasePositionValidity;
        assert true == validBoundaryPositionValidity;
    }

    @Test
    public void inValid_isValidMove() {
        // Given
        Position positionOutsideBoundary = new Position(3,4, Direction.NORTH);

        // When
        boolean positionOutsideBoundaryValidity = rectangular3by3Plateau.isValidMove(positionOutsideBoundary);

        // Then
        assert false == positionOutsideBoundaryValidity;
    }
}
