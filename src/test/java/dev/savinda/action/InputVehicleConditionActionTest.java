package dev.savinda.action;

import dev.savinda.action.impl.InputVehicleConditionAction;
import dev.savinda.dto.CalculatorRequestDto;
import org.junit.Assert;
import org.junit.Test;

public class InputVehicleConditionActionTest {
    @Test
    public void givenInvalidInput_whenExecute_thenThrowException() {
        // Arrange
        String input = "abcd";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputVehicleConditionAction action = new InputVehicleConditionAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> action.execute(input, request));
    }

    @Test
    public void givenValidInput_whenExecute_thenSetVehicleCondition() {
        // Arrange
        String input = "baru";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act
        InputVehicleConditionAction action = new InputVehicleConditionAction();
        action.execute(input, request);

        // Assert
        Assert.assertEquals("NEW", request.getVehicleCondition().name());

        // Arrange
        input = "bekas";

        // Act
        action.execute(input, request);

        // Assert
        Assert.assertEquals("USED", request.getVehicleCondition().name());
    }
}
