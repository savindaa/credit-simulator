package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class InputCreditAmountView implements IActionView {
    @Override
    public void render() {
        System.out.print("Jumlah Pinjaman Total: ");
    }

    @Override
    public void renderError(Exception e) {
        System.out.printf("%sJumlah Pinjaman Tidak Valid: %s%s\n", ViewTextColor.RED, e.getMessage(), ViewTextColor.RESET);
    }
}
