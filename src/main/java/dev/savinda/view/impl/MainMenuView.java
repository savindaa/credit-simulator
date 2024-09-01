package dev.savinda.view.impl;

import dev.savinda.model.ViewTextColor;
import dev.savinda.view.IActionView;

public class MainMenuView implements IActionView {
    public void render() {
        System.out.print(ViewTextColor.BLUE);
        System.out.println("Selamat Datang di Aplikasi Credit Simulator");
        System.out.println("Menu tersedia: ");
        System.out.println("1. Simulasi Kredit");
        System.out.println("2. Exit");
        System.out.print(ViewTextColor.RESET);
        System.out.print("Pilih menu: ");
    }

    @Override
    public void renderError(Exception e) {
    }
}
