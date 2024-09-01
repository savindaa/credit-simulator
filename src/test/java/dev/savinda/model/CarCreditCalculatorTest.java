package dev.savinda.model;

import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.dto.CalculatorResultDto;
import dev.savinda.model.impl.CarCreditCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CarCreditCalculatorTest {
    @Test
    public void testCalculate() {
        // Arrange
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.USED);
        request.setAmount(BigDecimal.valueOf(100_000_000L));
        request.setDownPaymentRate(0.25);
        request.setTenor(3);

        // Act
        CarCreditCalculator calculator = new CarCreditCalculator();
        List<CalculatorResultDto> result = calculator.calculate(request);

        // Assert
        Assert.assertEquals(3, result.size());
        // 1st year
        Assert.assertEquals(BigDecimal.valueOf(2_250_000.00).setScale(2, RoundingMode.HALF_UP), result.get(0).getMonthlyPayment());
        // 2nd year
        Assert.assertEquals(BigDecimal.valueOf(2_432_250).setScale(2, RoundingMode.HALF_UP), result.get(1).getMonthlyPayment());
        // 3rd year
        Assert.assertEquals(BigDecimal.valueOf(2_641_423.50).setScale(2, RoundingMode.HALF_UP), result.get(2).getMonthlyPayment());
    }
}
