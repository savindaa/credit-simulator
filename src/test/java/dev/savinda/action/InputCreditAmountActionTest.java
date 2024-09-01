package dev.savinda.action;

import dev.savinda.action.impl.InputCreditAmountAction;
import dev.savinda.dto.CalculatorRequestDto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class InputCreditAmountActionTest {
    @Test
    public void givenInvalidCreditAmount_whenExecute_thenThrowException() {
        // Arrange
        String input = "abcd";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputCreditAmountAction action = new InputCreditAmountAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenNegativeCreditAmount_whenExecute_thenThrowException() {
        // Arrange
        String input = "-100000";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputCreditAmountAction action = new InputCreditAmountAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenBelowMinimumCreditAmount_whenExecute_thenThrowException() {
        // Arrange
        String input = "100";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputCreditAmountAction action = new InputCreditAmountAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenAboveMaximumCreditAmount_whenExecute_thenThrowException() {
        // Arrange
        String input = "1000000001";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act & Assert
        InputCreditAmountAction action = new InputCreditAmountAction();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            action.execute(input, request);
        });
    }

    @Test
    public void givenValidCreditAmount_whenExecute_thenSetCreditAmount() {
        // Arrange
        String input = "100000000";
        CalculatorRequestDto request = new CalculatorRequestDto();

        // Act
        InputCreditAmountAction action = new InputCreditAmountAction();
        action.execute(input, request);

        // Assert
        Assert.assertEquals(BigDecimal.valueOf(100_000_000), request.getAmount());
    }
}
