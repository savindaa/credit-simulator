package dev.savinda.model.impl;

import static dev.savinda.configuration.AppConfiguration.CAR_INTEREST_RATE;

public class CarCreditCalculator extends AbstractCreditCalculator {
    @Override
    Double getInterestRate() {
        return CAR_INTEREST_RATE;
    }
}
