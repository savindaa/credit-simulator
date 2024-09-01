package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class InputTenorView implements IActionView {
    @Override
    public void render() {
        System.out.print("Tenor Pinjaman (1-6 Tahun): ");
    }

    @Override
    public void renderError(Exception e) {
        System.out.printf("%sTenor Pinjaman Tidak Valid: %s%s\n", ViewTextColor.RED, e.getMessage(), ViewTextColor.RESET);
    }
}
