package dev.savinda.action.impl;

import dev.savinda.action.IAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.model.VehicleType;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.InputVehicleTypeView;

public class InputVehicleTypeAction implements IAction {
    private static final IActionView view = new InputVehicleTypeView();

    @Override
    public IActionView getView() {
        return view;
    }

    @Override
    public void execute(String input, CalculatorRequestDto request) {
        VehicleType vehicleType = VehicleType.fromString(input);
        request.setVehicleType(vehicleType);
    }
}
