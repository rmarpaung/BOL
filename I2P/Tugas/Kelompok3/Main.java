import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pilihanMenu;
        int bilangan1 = 0;
        int bilangan2 = 0;

        do {
            pilihanMenu = 0;
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println("Menu hari ini");
            System.out.println("1. Penjumlahan bilangan prima");
            System.out.println("2. Jumlah bilangan prima");
            System.out.println("3. Keluar");
            System.out.println("-----------------------------------------");
            System.out.print("Masukkan pilihan: ");

            // Baca pilihan yang dimasukkan
            try {
                pilihanMenu = input.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Silakan masukkan pilihan yang benar.");
                input.nextLine();
            }

            // Jika pilihan yang dipilih adalah menu 1 atau menu 2, maka minta masukan
            // bilangan 1 dan bilangan 2
            if (pilihanMenu == 1 || pilihanMenu == 2) {

                // Masukan bilangan 1
                do {
                    bilangan1 = 0;
                    System.out.print("Masukkan bilangan 1: ");

                    try {
                        bilangan1 = input.nextInt();
                    } catch (InputMismatchException ime) {
                        input.nextLine();
                    }

                    if (bilangan1 <= 1) {
                        System.out.println(
                                "Karakter yang dimasukkan harus berupa angka positif lebih besar dari 1.");
                    }
                } while (bilangan1 < 2);

                // Masukan bilangan 2
                do {
                    bilangan2 = 0;
                    System.out.print("Masukkan bilangan 2: ");

                    try {
                        bilangan2 = input.nextInt();
                    } catch (InputMismatchException ime) {
                        input.nextLine();
                    }

                    if (bilangan2 <= bilangan1) {
                        System.out.println(
                                "Karakter yang dimasukkan harus berupa angka positif lebih besar dari bilangan 1.");
                    }
                } while (bilangan2 <= bilangan1);

                if (pilihanMenu == 1) {
                    totalBilanganPrima(bilangan1, bilangan2);
                } else if (pilihanMenu == 2) {
                    cacahBilanganPrima(bilangan1, bilangan2);
                }
            }
        } while (pilihanMenu != 3);

        input.close();
    }

    private static void cacahBilanganPrima(int awal, int akhir) {
        System.out.println();
        System.out.println("Bilangan prima antara " + awal + " dan " + akhir + " adalah: ");

        int cacahJumlah = 0;

        for (int i = awal; i <= akhir; i++) {
            int cacahBagi = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cacahBagi++;
                }
            }

            // Jika terdapat 2 kali pembagian dengan sisa 0, berarti bilangan prima. Karena
            // bilangan prima hanya bisa dibagi oleh 2 bilangan: 1 dan bilangan itu sendiri.
            if (cacahBagi == 2) {
                cacahJumlah++;
                System.out.print(i + "\t");
            }
        }

        System.out.println();
        System.out.println("Jumlah bilangan prima: " + cacahJumlah);
    }

    private static void totalBilanganPrima(int awal, int akhir) {
        System.out.println();
        System.out.println("Bilangan prima antara " + awal + " dan " + akhir + " adalah: ");

        int total = 0;

        for (int i = awal; i <= akhir; i++) {
            int cacahBagi = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cacahBagi++;
                }
            }

            // Jika terdapat 2 kali pembagian dengan sisa 0, berarti bilangan prima. Karena
            // bilangan prima hanya bisa dibagi oleh 2 bilangan: 1 dan bilangan itu sendiri.
            if (cacahBagi == 2) {
                total += i;
                System.out.print(i + "\t");
            }
        }

        System.out.println();
        System.out.println("Penjumlahan bilangan prima: " + total);
    }
}
