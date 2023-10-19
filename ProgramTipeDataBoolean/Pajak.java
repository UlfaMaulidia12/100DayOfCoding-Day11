package ProgramTipeDataBoolean;

import java.util.Scanner;

public class Pajak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulangi;

        do {
            System.out.println("=== Kalkulator Pajak ===");
            double pendapatanTahunan = getInputDouble("Masukkan Pendapatan Tahunan: $");
            double batasPendapatan = getInputDouble("Masukkan Batas Pendapatan untuk Pajak: $");
            double pajakTahunan = calculateTax(pendapatanTahunan, batasPendapatan);

            System.out.println("=======================================");
            System.out.printf("Pendapatan Tahunan\t\t: $%.2f%n", pendapatanTahunan);
            System.out.printf("Batas Pendapatan untuk Pajak\t: $%.2f%n", batasPendapatan);
            System.out.println("=======================================");

            if (pajakTahunan > 0) {
                System.out.printf("Anda harus membayar pajak sebesar: $%.2f%n", pajakTahunan);
            } else {
                System.out.println("Anda tidak harus membayar pajak.");
            }

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih telah menggunakan kalkulator pajak!");
    }

    private static double getInputDouble(String message) {
        double value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = Double.parseDouble(new Scanner(System.in).nextLine());
                if (value < 0) {
                    System.out.println("Input tidak valid. Harus lebih dari atau sama dengan nol.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka desimal yang benar.");
            }
        }
        return value;
    }

    private static double calculateTax(double pendapatanTahunan, double batasPendapatan) {
        if (pendapatanTahunan > batasPendapatan) {
            return pendapatanTahunan * 0.1; // Contoh persentase pajak 10%
        }
        return 0; // Tidak ada pajak jika pendapatan di bawah batas
    }

    private static char getYesNoInput(String message) {
        char response;
        while (true) {
            System.out.print(message);
            response = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (response == 'Y' || response == 'y' || response == 'N' || response == 'n') {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Masukkan 'Y' atau 'N'.");
            }
        }
        return response;
    }
}
