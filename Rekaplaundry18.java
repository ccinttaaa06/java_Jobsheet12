import java.util.Scanner;

public class RekapLaundry18 {
    static Scanner sc = new Scanner(System.in);

    static void inputData(String[] layanan, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Berat " + layanan[i] + " hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilData(String[] layanan, String[] hari, int[][] data) {
        System.out.printf("%-14s", "Layanan");
        for (int j = 0; j < hari.length; j++) {
            System.out.printf("%8s", hari[j]);
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s", layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%8d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void layananTertinggi(String[] layanan, int[][] data) {
        int idx = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idx)) {
                idx = i;
            }
        }
        System.out.println("Layanan dengan total berat tertinggi: " + layanan[idx]
                + " (" + totalPerLayanan(data, idx) + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxTerbesar = 0;
        int totalTerbesar = 0;
        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > totalTerbesar) {
                totalTerbesar = totalHari;
                idxTerbesar = j;
            }
        }
        return idxTerbesar;
    }

    static void tampilPendapatan(String[] layanan, int[] harga, int[][] data) {
        int totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            totalPendapatan += pendapatan;
            System.out.println(layanan[i] + ": Rp" + pendapatan);
        }
        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = new int[layanan.length][hari.length];

        inputData(layanan, data);

        System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
        tampilData(layanan, hari, data);

        System.out.println();
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        layananTertinggi(layanan, data);
        System.out.println("Hari tersibuk: " + hari[hariTersibuk(data)]);

        System.out.println("\n=== PENDAPATAN ===");
        tampilPendapatan(layanan, harga, data);
    }
}