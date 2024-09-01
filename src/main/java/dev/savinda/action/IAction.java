package dev.savinda.action;

import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.view.IActionView;

public interface IAction {
    IActionView getView();

    void execute(String input, CalculatorRequestDto request);
}
