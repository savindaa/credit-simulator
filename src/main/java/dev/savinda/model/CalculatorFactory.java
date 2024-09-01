package dev.savinda.model;

import dev.savinda.model.impl.CarCreditCalculator;
import dev.savinda.model.impl.MotorcycleCreditCalculator;

public class CalculatorFactory {
    public static ICreditCalculator getCreditCalculator(VehicleType type) {
        switch (type) {
            case CAR:
                return new CarCreditCalculator();
            case MOTORCYCLE:
                return new MotorcycleCreditCalculator();
            default:
                throw new IllegalArgumentException("Invalid calculator type");
        }
    }
}
