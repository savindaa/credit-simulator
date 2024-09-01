package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class InputVehicleTypeView implements IActionView {
    @Override
    public void render() {
        System.out.print("Masukan Jenis Kendaraan (Motor|Mobil): ");
    }

    @Override
    public void renderError(Exception e) {
        System.out.printf("%sJenis Kendaraan Tidak Valid%s\n", ViewTextColor.RED, ViewTextColor.RESET);

    }
}
