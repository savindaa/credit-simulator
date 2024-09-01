package dev.savinda.model.impl;

import static dev.savinda.configuration.AppConfiguration.MOTORCYCLE_INTEREST_RATE;

public class MotorcycleCreditCalculator extends AbstractCreditCalculator {
    @Override
    Double getInterestRate() {
        return MOTORCYCLE_INTEREST_RATE;
    }
}
