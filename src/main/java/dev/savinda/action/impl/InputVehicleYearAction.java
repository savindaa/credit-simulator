package dev.savinda.action.impl;

import dev.savinda.action.IAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.model.VehicleCondition;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.InputVehicleYearView;

import java.util.Calendar;

public class InputVehicleYearAction implements IAction {
    private static final IActionView view = new InputVehicleYearView();

    @Override
    public IActionView getView() {
        return view;
    }

    @Override
    public void execute(String input, CalculatorRequestDto request) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        int year = Integer.parseInt(input);

        if (request.getVehicleCondition() == null) {
            throw new IllegalArgumentException("Kondisi kendaraan belum diatur");
        }

        if (request.getVehicleCondition().equals(VehicleCondition.NEW) && year < currentYear) {
            throw new IllegalArgumentException("Tahun kendaraan baru tidak boleh memiliki tahun sebelum tahun ini");
        }
    }
}
