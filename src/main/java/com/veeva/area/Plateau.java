package com.veeva.area;

import com.veeva.position.Position;

/**
 * Represents a searchable area.
 */
public interface Plateau {

    /**
     * This method will check if location is a valid move or not.
     * @param position Position to check for
     * @return true if position is a valid location to be.
     */
    boolean isValidMove(Position position);

}
