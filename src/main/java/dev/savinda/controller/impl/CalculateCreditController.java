package dev.savinda.controller.impl;

import dev.savinda.action.IAction;
import dev.savinda.action.impl.*;
import dev.savinda.controller.IMenuController;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.dto.CalculatorResultDto;
import dev.savinda.model.CalculatorFactory;
import dev.savinda.model.ICreditCalculator;
import dev.savinda.view.impl.CalculatorResultView;

import java.util.List;

public class CalculateCreditController implements IMenuController {
    private final List<IAction> actions;
    private final CalculatorRequestDto request = new CalculatorRequestDto();
    private int currentActionIndex = 0;

    public CalculateCreditController() {
        this.actions = List.of(
                new InputVehicleTypeAction(),
                new InputVehicleConditionAction(),
                new InputVehicleYearAction(),
                new InputCreditAmountAction(),
                new InputLoanTermAction(),
                new InputDownPaymentPercentageAction()
        );
    }

    @Override
    public void render() {
        if (currentActionIndex < actions.size()) {
            IAction action = actions.get(currentActionIndex);
            action.getView().render();
        }
    }

    @Override
    public boolean execute(String input) {
        if (currentActionIndex < actions.size()) {
            IAction action = actions.get(currentActionIndex);
            try {
                action.execute(input, this.request);
            } catch (IllegalArgumentException e) {
                action.getView().renderError(e);
                return true;
            }

            if (currentActionIndex < actions.size() - 1) {
                currentActionIndex++;
                return true;
            }
        }

        ICreditCalculator calculator = CalculatorFactory.getCreditCalculator(this.request.getVehicleType());
        List<CalculatorResultDto> results = calculator.calculate(request);

        CalculatorResultView resultView = new CalculatorResultView();
        resultView.render(this.request, results);

        return false;
    }
}
