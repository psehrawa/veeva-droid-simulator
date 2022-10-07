package com.veeva.droid;

import com.veeva.area.Plateau;
import com.veeva.position.Position;
import lombok.Getter;

import java.util.List;

/**
 * This class represents a probe droid.
 */
@Getter
public class ProbeDroid implements Droid {
    private Position position;

    private Plateau plateau;

    public ProbeDroid(Position position, Plateau plateau) {
        this.position = position;
        this.plateau = plateau;
    }

    @Override
    public void navigate(List<DroidInstruction> droidInstructions) {
        for(DroidInstruction droidInstruction : droidInstructions) {
            switch (droidInstruction) {
                case LEFT:
                    toLeft();
                    break;
                case RIGHT:
                    toRight();
                    break;
                case MOVE:
                    move();
                    break;
            }
        }
    }

    @Override
    public void toRight() {
        position = getPosition().toRight();
    }

    @Override
    public void toLeft() {
        position = getPosition().toLeft();
    }

    @Override
    public void move() {
        Position newPosition = getPosition().move();
        if(getPlateau().isValidMove(newPosition)) {
            position = newPosition;
        } else {
            throw new IllegalStateException(newPosition + " is not a valid move.");
        }
    }
}
