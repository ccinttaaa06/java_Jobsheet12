import java.util.Scanner;

public class BankSampah18 {
    static Scanner sc = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("\nData setoran nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeks = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeks]) {
                indeks = i;
            }
        }
        return indeks;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(n);
        tampilSetoran(setoran);

        System.out.println("\nTotal berat setoran seluruh nasabah: " + totalSetoran(setoran) + " kg");

        System.out.println("\nSaldo setiap nasabah (Rp3.000 per kg):");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": Rp" + hitungSaldo(setoran[i], 3000));
        }

        int terbanyak = nasabahTerbanyak(setoran);
        System.out.println("\nSetoran terbesar: nasabah ke-" + (terbanyak + 1)
                + " (" + setoran[terbanyak] + " kg)");
    }
}