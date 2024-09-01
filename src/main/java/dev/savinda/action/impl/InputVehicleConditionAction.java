package dev.savinda.action.impl;

import dev.savinda.action.IAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.model.VehicleCondition;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.InputVehicleConditionView;

public class InputVehicleConditionAction implements IAction {
    private static final IActionView view = new InputVehicleConditionView();

    @Override
    public IActionView getView() {
        return view;
    }

    @Override
    public void execute(String input, CalculatorRequestDto request) {
        VehicleCondition vehicleCondition = VehicleCondition.fromString(input);
        request.setVehicleCondition(vehicleCondition);
    }
}
