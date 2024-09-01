package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class InputDownPaymentPercentageView implements IActionView {
    @Override
    public void render() {
        System.out.print("Jumlah DP (dalam persen): ");
    }

    @Override
    public void renderError(Exception e) {
        System.out.printf("%sJumlah DP Tidak Valid: %s%s\n", ViewTextColor.RED, e.getMessage(), ViewTextColor.RESET);
    }
}
