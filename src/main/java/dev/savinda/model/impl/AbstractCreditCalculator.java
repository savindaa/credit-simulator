package dev.savinda.model.impl;

import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.dto.CalculatorResultDto;
import dev.savinda.model.ICreditCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static dev.savinda.configuration.AppConfiguration.INTEREST_YOY_EVERY_1_YEAR;
import static dev.savinda.configuration.AppConfiguration.INTEREST_YOY_EVERY_2_YEAR;

public abstract class AbstractCreditCalculator implements ICreditCalculator {
    abstract Double getInterestRate();

    @Override
    public List<CalculatorResultDto> calculate(CalculatorRequestDto request) {
        BigDecimal downPaymentAmount = request.getAmount().multiply(BigDecimal.valueOf(request.getDownPaymentRate()));
        BigDecimal loanAmount = request.getAmount().subtract(downPaymentAmount);
        BigDecimal totalCredit = loanAmount.multiply(BigDecimal.valueOf(getInterestRate())).add(loanAmount);

        List<CalculatorResultDto> results = new ArrayList<>();
        Double interestRate = getInterestRate();
        long tenorInMonths = 12L * request.getTenor();

        for (int year = 0; year < request.getTenor(); year++) {
            BigDecimal monthlyInstallment = totalCredit.divide(BigDecimal.valueOf(tenorInMonths - 12L * year), RoundingMode.HALF_UP);
            BigDecimal yearlyInstallment = monthlyInstallment.multiply(BigDecimal.valueOf(12));

            CalculatorResultDto result = new CalculatorResultDto();
            result.setInterestRate(interestRate);
            result.setMonthlyPayment(monthlyInstallment.setScale(2, RoundingMode.HALF_UP));
            result.setYearsOfPayment(year);
            results.add(result);

            interestRate += (year + 1) % 2 == 0 ? INTEREST_YOY_EVERY_2_YEAR : INTEREST_YOY_EVERY_1_YEAR;

            totalCredit = totalCredit.subtract(yearlyInstallment);
            totalCredit = totalCredit.multiply(BigDecimal.valueOf(interestRate)).add(totalCredit);
        }

        return results;
    }
}
