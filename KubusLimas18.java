import java.util.Scanner;

public class KubusLimas18 {
    static int luasPersegi(int s) {
        return s * s;
    }

    static int volumeKubus(int s) {
        return s * s * s;
    }

    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    static double volumeLimasPersegi(int s, int t) {
        // luas alas x tinggi / 3 ; dibagi 3.0 agar tidak terpotong
        return luasPersegi(s) * t / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU BANGUN RUANG ===");
            System.out.println("1. Luas persegi");
            System.out.println("2. Volume kubus");
            System.out.println("3. Luas permukaan kubus");
            System.out.println("4. Volume limas persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            if (pilihan >= 1 && pilihan <= 3) {
                System.out.print("Masukkan sisi: ");
                int s = sc.nextInt();
                if (pilihan == 1) {
                    System.out.println("Luas persegi = " + luasPersegi(s));
                } else if (pilihan == 2) {
                    System.out.println("Volume kubus = " + volumeKubus(s));
                } else {
                    System.out.println("Luas permukaan kubus = " + luasPermukaanKubus(s));
                }
            } else if (pilihan == 4) {
                System.out.print("Masukkan sisi alas: ");
                int s = sc.nextInt();
                System.out.print("Masukkan tinggi: ");
                int t = sc.nextInt();
                System.out.println("Volume limas persegi = " + volumeLimasPersegi(s, t));
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak tersedia");
            }
        } while (pilihan != 0);

        System.out.println("Program selesai.");
        sc.close();
    }
}