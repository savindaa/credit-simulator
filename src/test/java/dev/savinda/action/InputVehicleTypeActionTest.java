package dev.savinda.action;

import dev.savinda.action.impl.InputVehicleTypeAction;
import dev.savinda.dto.CalculatorRequestDto;
import org.junit.Assert;
import org.junit.Test;

public class InputVehicleTypeActionTest {
    @Test
    public void givenInvalidInput_whenExecute_thenThrowException() {
        // Arrange
        String input = "abcd";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputVehicleTypeAction action = new InputVehicleTypeAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> action.execute(input, request));
    }

    @Test
    public void givenValidInput_whenExecute_thenSetVehicleCondition() {
        // Arrange
        String input = "mobil";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act
        InputVehicleTypeAction action = new InputVehicleTypeAction();
        action.execute(input, request);

        // Assert
        Assert.assertEquals("CAR", request.getVehicleType().name());

        // Arrange
        input = "motor";

        // Act
        action.execute(input, request);

        // Assert
        Assert.assertEquals("MOTORCYCLE", request.getVehicleType().name());
    }
}
