package dev.savinda.action.impl;

import dev.savinda.action.IAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.model.VehicleCondition;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.InputDownPaymentPercentageView;

public class InputDownPaymentPercentageAction implements IAction {
    private static final IActionView view = new InputDownPaymentPercentageView();

    @Override
    public IActionView getView() {
        return view;
    }

    @Override
    public void execute(String input, CalculatorRequestDto request) {
        double downPayment;
        try {
            downPayment = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Masukkan Angka");
        }

        if (request.getVehicleCondition() == null) {
            throw new IllegalArgumentException("Pilih kondisi kendaraan terlebih dahulu");
        }

        if (request.getVehicleCondition().equals(VehicleCondition.NEW) && downPayment < 35) {
            throw new IllegalArgumentException("Uang Muka minimal 35% untuk kendaraan baru");
        }

        if (downPayment < 25) {
            throw new IllegalArgumentException("Uang Muka minimal 25% untuk kendaraan bekas");
        }

        if (downPayment > 100) {
            throw new IllegalArgumentException("Uang Muka tidak boleh lebih dari 100%");
        }

        request.setDownPaymentRate(downPayment / 100);
    }
}
