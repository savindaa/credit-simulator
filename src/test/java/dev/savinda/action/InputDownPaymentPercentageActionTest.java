package dev.savinda.action;

import dev.savinda.action.impl.InputDownPaymentPercentageAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.model.VehicleCondition;
import org.junit.Assert;
import org.junit.Test;

public class InputDownPaymentPercentageActionTest {
    @Test
    public void givenInvalidInput_whenExecute_thenShouldThrowException() {
        // Arrange
        String input = "abcd";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputDownPaymentPercentageAction action = new InputDownPaymentPercentageAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenMoreThan100Percent_whenExecute_thenShouldThrowException() {
        // Arrange
        String input = "101";
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.NEW);

        // Act & Assert
        InputDownPaymentPercentageAction action = new InputDownPaymentPercentageAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenEmptyVehicleCondition_whenExecute_thenShouldThrowException() {
        // Arrange
        String input = "50";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputDownPaymentPercentageAction action = new InputDownPaymentPercentageAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenLessThanMinimumForUsedVehicle_whenExecute_thenShouldThrowException() {
        // Arrange
        String input = "10";
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.USED);

        // Act & Assert
        InputDownPaymentPercentageAction action = new InputDownPaymentPercentageAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenLessThanMinimumForNewVehicle_whenExecute_thenShouldThrowException() {
        // Arrange
        String input = "10";
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.NEW);

        // Act & Assert
        InputDownPaymentPercentageAction action = new InputDownPaymentPercentageAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenValidInput_whenExecute_thenShouldSetDownPaymentRate() {
        // Arrange
        String input = "50";
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.NEW);

        // Act
        InputDownPaymentPercentageAction action = new InputDownPaymentPercentageAction();
        action.execute(input, request);

        // Assert
        Assert.assertEquals(0.5, request.getDownPaymentRate(), 0.0);
    }
}
