import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float beratKg, beratPon, beratOns, beratGram;
        Scanner masukan = new Scanner(System.in);

        System.out.print("Masukkan jumlah Kilogram yang akan dikonversi: ");

        // Periksa apakah nilai yang dimasukkan berupa angka atau mengandung karakter
        // yang bukan angka. Pemeriksaan menggunakan blok try..catch dimana jika nilai
        // yang dimasukkan bukan berupa angka atau angka yang terlalu besar (diluar
        // rentang tipe data float) maka akan menyebabkan error, dan error yang terjadi
        // akan program berpindah ke blok catch.
        try {
            beratKg = masukan.nextFloat();
        } catch (InputMismatchException ex) {
            System.out.println("Data yang dimasukkan hanya bisa berupa desimal (pecahan) atau bilangan bulat saja.");
            masukan.close();
            return;
        }

        beratPon = beratKg * 2;         // 1 Kg = 2 Pon
        beratOns = beratPon * 5;        // 1 Pon = 5 Ons
        beratGram = beratOns * 100;     // 1 Ons = 100 gram

        // Jika masukan berupa bilangan bulat (int), maka outputnya dikonversi ke bentuk
        // integer, dan jika tidak, berarti merupakan bilangan pecahan (float) sehingga
        // tidak perlu dikonversi.
        if (beratKg % 1 == 0) {         
            // bilangan bulat (int)
            System.out.println((int) beratKg + " Kg sama dengan = " + (int) beratPon + " pon atau " + (int) beratOns
                    + " ons atau " + (int) beratGram + " gram ");
        } else {                        
            // bilangan pecahan (float)
            System.out.println(beratKg + " Kg sama dengan = " + beratPon + " pon atau " + beratOns + " ons atau "
                    + beratGram + " gram ");
        }

        masukan.close();
    }
}
