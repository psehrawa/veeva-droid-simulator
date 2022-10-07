package com.veeva.droid;

import com.veeva.position.Position;

import java.util.List;

/**
 * This type represents a droid and its behavior.
 */
public interface Droid {

    /**
     * This method will rotate the droid 90 degree to the right.
     */
    void toRight();

    /**
     * This method will rotate the droid 90 degree to the left.
     */
    void toLeft();

    /**
     * This method will move the droid.
     * Throws IllegalStateException when an instruction forces the droid outside the search area.
     */
    void move();

    /**
     * This method will navigate the droid as per instructions.
     * @param droidInstructions Instructions for the droid.
     */
    void navigate(List<DroidInstruction> droidInstructions);

    /**
     * Returns position of droid.
     * @return Position
     */
    Position getPosition();
}
