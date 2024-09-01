package dev.savinda.dto;

import java.math.BigDecimal;

public class CalculatorResultDto {
    private BigDecimal monthlyPayment;
    private Integer yearsOfPayment;
    private Double interestRate;

    public CalculatorResultDto() {
    }

    public CalculatorResultDto(BigDecimal monthlyPayment, Integer yearsOfPayment, Double interestRate) {
        this.monthlyPayment = monthlyPayment;
        this.yearsOfPayment = yearsOfPayment;
        this.interestRate = interestRate;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Integer getYearsOfPayment() {
        return yearsOfPayment;
    }

    public void setYearsOfPayment(Integer yearsOfPayment) {
        this.yearsOfPayment = yearsOfPayment;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
