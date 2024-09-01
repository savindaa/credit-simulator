package dev.savinda.action;

import dev.savinda.action.impl.InputVehicleYearAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.model.VehicleCondition;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class InputVehicleYearActionTest {
    @Test
    public void givenInvalidInput_whenExecute_thenThrowException() {
        // Arrange
        String input = "abcd";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputVehicleYearAction action = new InputVehicleYearAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> action.execute(input, request));
    }

    @Test
    public void givenEmptyVehicleType_whenExecute_thenThrowException() {
        // Arrange
        String input = "2020";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputVehicleYearAction action = new InputVehicleYearAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> action.execute(input, request));
    }

    @Test
    public void givenLessThanCurrentYearForNewVehicle_whenExecute_thenThrowException() {
        // Arrange
        String input = "2020";
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.NEW);

        // Act & Assert
        InputVehicleYearAction action = new InputVehicleYearAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> action.execute(input, request));
    }

    @Test
    public void givenValidInput_whenExecute_thenNotThrowException() {
        // Arrange
        String input = Calendar.getInstance().get(Calendar.YEAR) + "";
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.NEW);

        // Act
        InputVehicleYearAction action = new InputVehicleYearAction();
        action.execute(input, request);
    }
}
