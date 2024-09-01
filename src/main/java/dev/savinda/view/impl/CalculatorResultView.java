package dev.savinda.view.impl;

import dev.savinda.dto.CalculatorRequestDto;
import dev.savinda.dto.CalculatorResultDto;
import dev.savinda.model.ViewTextColor;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;

public class CalculatorResultView {
    public void render(CalculatorRequestDto request, List<CalculatorResultDto> results) {
        NumberFormat currencyFormat = NumberFormat.getInstance();
        currencyFormat.setMaximumFractionDigits(2);
        currencyFormat.setCurrency(Currency.getInstance("IDR"));
        currencyFormat.setMinimumFractionDigits(2);

        System.out.printf("\n%sData Permintaan Kredit:%s\n", ViewTextColor.GREEN, ViewTextColor.RESET);
        System.out.printf("Jenis Kendaraan:      %s\n", request.getVehicleType());
        System.out.printf("Kondisi Kendaraan:    %s\n", request.getVehicleCondition());
        System.out.printf("Tahun Kendaraan:      %d\n", request.getVehicleYear());
        System.out.printf("Jumlah Pinjaman:      %s\n", String.format("Rp%s", currencyFormat.format(request.getAmount())));
        System.out.printf("Tenor Pinjaman:       %d Tahun\n", request.getTenor());
        System.out.printf("Persentase Uang Muka: %s%%\n", DecimalFormat.getInstance().format(request.getDownPaymentRate() * 100));

        System.out.printf("\n%sHasil Perhitungan:\n%s", ViewTextColor.GREEN, ViewTextColor.RESET);
        for (CalculatorResultDto result : results) {
            System.out.printf("Cicilan Tahun ke-%d: %15s/bln , Suku Bunga %s%% \n",
                    result.getYearsOfPayment() + 1,
                    String.format("Rp%s", currencyFormat.format(result.getMonthlyPayment())),
                    DecimalFormat.getInstance().format(result.getInterestRate() * 100));
        }
        System.out.println("====================================");
    }
}
