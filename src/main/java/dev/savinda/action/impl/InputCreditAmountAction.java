package dev.savinda.action.impl;

import dev.savinda.action.IAction;
import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.InputCreditAmountView;

import java.math.BigDecimal;

import static dev.savinda.configuration.AppConfiguration.MAX_LOAN_AMOUNT;
import static dev.savinda.configuration.AppConfiguration.MIN_LOAN_AMOUNT;

public class InputCreditAmountAction implements IAction {
    private static final IActionView view = new InputCreditAmountView();

    @Override
    public IActionView getView() {
        return view;
    }

    @Override
    public void execute(String input, CalculatorRequestDto request) {
        int loanAmount;
        try {
            loanAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Masukkan Angka");
        }

        if (loanAmount > MAX_LOAN_AMOUNT) {
            throw new IllegalArgumentException("Maksimum Pinjaman Rp. " + MAX_LOAN_AMOUNT);
        }

        if (loanAmount < MIN_LOAN_AMOUNT) {
            throw new IllegalArgumentException("Minimal Pinjaman Rp. " + MIN_LOAN_AMOUNT);
        }

        request.setAmount(BigDecimal.valueOf(loanAmount));
    }
}

