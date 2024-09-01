package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class InputVehicleYearView implements IActionView {
    @Override
    public void render() {
        System.out.print("Tahun Kendaraan: ");
    }

    @Override
    public void renderError(Exception e) {
        System.out.printf("%sTahun Kendaraan Tidak Valid: %s%s\n", ViewTextColor.RED, e.getMessage(), ViewTextColor.RESET);
    }
}
