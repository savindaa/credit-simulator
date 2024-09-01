package dev.savinda.action.impl;

import dev.savinda.action.IAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.InputTenorView;

import static dev.savinda.configuration.AppConfiguration.MAX_TERM;
import static dev.savinda.configuration.AppConfiguration.MIN_TERM;

public class InputLoanTermAction implements IAction {
    private static final IActionView view = new InputTenorView();

    @Override
    public IActionView getView() {
        return view;
    }

    @Override
    public void execute(String input, CalculatorRequestDto request) {
        int tenor;
        try {
            tenor = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Masukkan Angka");
        }

        if (tenor < MIN_TERM) {
            throw new IllegalArgumentException("Tenor minimal 1 tahun");
        }

        if (tenor > MAX_TERM) {
            throw new IllegalArgumentException("Tenor maksimal 6 tahun");
        }

        request.setTenor(tenor);
    }
}
