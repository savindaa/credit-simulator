package dev.savinda.model;

import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.dto.CalculatorResultDto;

import java.util.List;

public interface ICreditCalculator {
    List<CalculatorResultDto> calculate(CalculatorRequestDto request);
}
