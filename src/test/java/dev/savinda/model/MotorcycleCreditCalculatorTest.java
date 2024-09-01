package dev.savinda.model;

import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.dto.CalculatorResultDto;
import dev.savinda.model.impl.MotorcycleCreditCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MotorcycleCreditCalculatorTest {
    @Test
    public void testCalculate() {
        // Arrange
        CalculatorRequestDto request = new CalculatorRequestDto();
        request.setVehicleCondition(VehicleCondition.USED);
        request.setAmount(BigDecimal.valueOf(100_000_000L));
        request.setDownPaymentRate(0.25);
        request.setTenor(3);

        // Act
        MotorcycleCreditCalculator calculator = new MotorcycleCreditCalculator();
        List<CalculatorResultDto> result = calculator.calculate(request);

        // Assert
        Assert.assertEquals(3, result.size());
        // 1st year
        Assert.assertEquals(BigDecimal.valueOf(2_270_833.33).setScale(2, RoundingMode.HALF_UP), result.get(0).getMonthlyPayment());
        // 2nd year
        Assert.assertEquals(BigDecimal.valueOf(2_477_479.17).setScale(2, RoundingMode.HALF_UP), result.get(1).getMonthlyPayment());
        // 3rd year
        Assert.assertEquals(BigDecimal.valueOf(2_715_317.17).setScale(2, RoundingMode.HALF_UP), result.get(2).getMonthlyPayment());
    }
}
