package com.veeva.bots;

import com.veeva.droid.DroidInstruction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DroidInstructionTest {

    @Test
    public void validInstruction_parseInstruction() {
        // Given
        Map<Character, DroidInstruction> rawDataToInstructionMap = new HashMap<>(){{
           put('M', DroidInstruction.MOVE);
           put('L', DroidInstruction.LEFT);
           put('R', DroidInstruction.RIGHT);
        }};

        for(Map.Entry<Character, DroidInstruction> rawDataToInstruction : rawDataToInstructionMap.entrySet()) {
            // When
            DroidInstruction parsedInstruction = DroidInstruction.parseInstruction(rawDataToInstruction.getKey());

            // Then
            assert parsedInstruction == rawDataToInstruction.getValue();
        }
    }

    @Test
    public void inValidInstruction_parseInstruction_throwIllegalArgumentException() {
        // Given
        Character invalidInstruction = 'X';

        // When
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> DroidInstruction.parseInstruction('X'));

        // Then
        assert throwable instanceof IllegalArgumentException;
    }
}
