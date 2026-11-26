import java.util.Scanner;

public class Kafe18 {
    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("==========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga18(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int persen = 0;

        if (kodePromo.equals("DISKON50")) {
            persen = 50;
        } else if (kodePromo.equals("DISKON30")) {
            persen = 30;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            persen += 10;
        }

        // kalikan dulu baru bagi 100 agar hasil int tidak terpotong menjadi 0
        return total * persen / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();
        System.out.print("Apakah pelanggan member? (y/n): ");
        boolean isMember = sc.nextLine().equalsIgnoreCase("y");

        Menu(nama, isMember);

        int totalHarga = 0;
        String lagi;
        do {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();
            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
            } else {
                totalHarga += hitungTotalHarga18(pilihanMenu, banyakItem);
            }

            System.out.print("Tambah pesanan lain? (y/n): ");
            lagi = sc.next();
        } while (lagi.equalsIgnoreCase("y"));

        System.out.print("Masukkan kode promo (DISKON50 / DISKON30): ");
        String kodePromo = sc.next();

        int diskon = hitungDiskon(totalHarga, kodePromo, isMember);

        System.out.println("\nTotal harga          : Rp" + totalHarga);
        System.out.println("Besar diskon         : Rp" + diskon);
        System.out.println("Total yang dibayar   : Rp" + (totalHarga - diskon));
        sc.close();
    }
}
