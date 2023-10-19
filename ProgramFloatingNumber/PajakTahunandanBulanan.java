package ProgramFloatingNumber;

import java.util.Scanner;

public class PajakTahunandanBulanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulangi;

        do {
            System.out.println("=== Kalkulator Pajak ===");
            double pendapatanTahunan = getInput("Masukkan Pendapatan Tahunan: $");
            double tarifPajak = getInput("Masukkan Tarif Pajak Tahunan (%): ");
            double jumlahPajakTahunan = calculateTax(pendapatanTahunan, tarifPajak);
            double jumlahPajakBulanan = jumlahPajakTahunan / 12;

            System.out.println("\n=== Hasil Perhitungan Pajak ===");
            displayResult("Pendapatan Tahunan", pendapatanTahunan);
            displayResult("Tarif Pajak Tahunan", tarifPajak);
            displayResult("Pajak Tahunan", jumlahPajakTahunan);
            displayResult("Pajak Bulanan", jumlahPajakBulanan);

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih telah menggunakan kalkulator pajak!");
    }

    private static double getInput(String message) {
        double value = 0;

        while (true) {
            try {
                System.out.print(message);
                value = Double.parseDouble(new Scanner(System.in).nextLine());
                if (value >= 0) {
                    break;
                } else {
                    System.out.println("Masukkan angka positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Pastikan Anda memasukkan angka yang benar.");
            }
        }
        return value;
    }

    private static double calculateTax(double pendapatan, double tarif) {
        return pendapatan * tarif / 100;
    }

    private static void displayResult(String label, double value) {
        System.out.printf("%-20s: $%.2f%n", label, value);
    }

    private static char getYesNoInput(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine().toLowerCase().charAt(0);
    }
}
