package dev.savinda.action;

import dev.savinda.action.impl.InputLoanTermAction;
import dev.savinda.dto.CalculatorRequestDto;
import org.junit.Assert;
import org.junit.Test;

public class InputLoanTermActionTest {
    @Test
    public void givenInvalidInput_whenExecute_thenThrowException() {
        // Arrange
        String input = "abcd";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputLoanTermAction action = new InputLoanTermAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenBelowMinimumTerm_whenExecute_thenThrowException() {
        // Arrange
        String input = "0";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputLoanTermAction action = new InputLoanTermAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenAboveMaximumTerm_whenExecute_thenThrowException() {
        // Arrange
        String input = "7";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputLoanTermAction action = new InputLoanTermAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenValidInput_whenExecute_thenSetRequest() {
        // Arrange
        String input = "6";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act
        InputLoanTermAction action = new InputLoanTermAction();
        action.execute(input, request);

        // Assert
        Integer expected = 6;
        Assert.assertEquals(expected, request.getTenor());
    }
}
