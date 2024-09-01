package dev.savinda.dto;

import dev.savinda.model.VehicleCondition;
import dev.savinda.model.VehicleType;

import java.math.BigDecimal;

public class CalculatorRequestDto {
    private VehicleType vehicleType;
    private VehicleCondition vehicleCondition;
    private BigDecimal amount;
    private Integer tenor;
    private Double downPaymentRate;
    private Integer vehicleYear;

    public CalculatorRequestDto() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public Double getDownPaymentRate() {
        return downPaymentRate;
    }

    public void setDownPaymentRate(Double downPaymentRate) {
        this.downPaymentRate = downPaymentRate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleCondition getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(VehicleCondition vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }
}
