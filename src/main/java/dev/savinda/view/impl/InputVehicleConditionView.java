package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class InputVehicleConditionView implements IActionView {
    @Override
    public void render() {
        System.out.print("Masukan Kondisi Kendaraan (Baru|Bekas): ");
    }

    @Override
    public void renderError(Exception e) {
        System.out.printf("%sKondisi Kendaraan Tidak Valid: %s%s\n", ViewTextColor.RED, e.getMessage(), ViewTextColor.RESET);
    }
}
