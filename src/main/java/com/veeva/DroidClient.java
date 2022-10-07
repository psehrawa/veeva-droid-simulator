package com.veeva;

import com.veeva.area.Plateau;
import com.veeva.area.RectangularPlateau;
import com.veeva.droid.Droid;
import com.veeva.droid.DroidInstruction;
import com.veeva.droid.ProbeDroid;
import com.veeva.position.Direction;
import com.veeva.position.Position;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DroidClient {

    /**
     * Methods parses the plateau data
     * and create and returns a RectangularPlateau object.
     */
    public static Plateau parsePlateau(String plateauData) {
        isValidString(plateauData);
        String[] coordinates = plateauData.trim().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new RectangularPlateau(x, y);
    }

    /**
     * Method parses position data in format x y D
     * and create and returns a Position Object
     */
    public static Position parsePosition(String positionData) {
        isValidString(positionData);
        String[] positionDataArr = positionData.trim().split(" ");
        int x = Integer.parseInt(positionDataArr[0]);
        int y = Integer.parseInt(positionDataArr[1]);
        Direction direction = Direction.parseDirection(positionDataArr[2].trim());
        return new Position(x, y, direction);
    }

    /**
     * Method parses droid instructions and
     * returns a List of DroidInstruction
     */
    public static List<DroidInstruction> parseInstructions(String instructionData) {
        isValidString(instructionData);
        List<DroidInstruction> droidInstructions = new LinkedList<>();
        for(Character character : instructionData.trim().toCharArray()) {
            droidInstructions.add(DroidInstruction.parseInstruction(character));
        }
        return droidInstructions;
    }

    /**
     * Method read and parses incoming commands
     * and returns List of all droids.
     */
    public static List<Droid> readAndExecuteCommands(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        Plateau plateau = parsePlateau(scanner.nextLine());
        List<Droid> droids = new LinkedList<>();

        while (scanner.hasNext()) {
            Position droidPosition = parsePosition(scanner.nextLine());
            List<DroidInstruction> droidInstructions = parseInstructions(scanner.nextLine());

            Droid probeDroid = new ProbeDroid(droidPosition, plateau);
            probeDroid.navigate(droidInstructions);
            droids.add(probeDroid);
        }

        return droids;
    }

    public static void main(String[] args) {
        List<Droid> droids = readAndExecuteCommands(System.in);
        for(Droid droid : droids) {
            System.out.println(droid.getPosition());
        }
    }

    /**
     * Method checks if the data is non-null and non-zero length.
     * Throws an IllegalArgumentException otherwise.
     */
    public static boolean isValidString(String data) {
        if(data == null || data.length() == 0) {
            throw new IllegalArgumentException("Data read error.");
        }
        return true;
    }
}