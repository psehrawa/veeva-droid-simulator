package com.veeva.droid;

import lombok.Getter;

/**
 * This enum represents possible droid instruction.
 */
@Getter
public enum DroidInstruction {
    LEFT,
    RIGHT,
    MOVE;

    /**
     * This method parses droid instruction.
     * Throws an IllegalArgumentException when illegal instruction is parsed.
     */
    public static DroidInstruction parseInstruction(Character instruction) {
        switch (instruction) {
            case 'L':
                return LEFT;
            case 'R':
                return RIGHT;
            case 'M':
                return MOVE;
        }
        throw new IllegalArgumentException("Illegal droid instruction " + instruction);
    }
}
