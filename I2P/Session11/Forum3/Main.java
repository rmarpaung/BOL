// Nama : Rimbun Marpaung
// NIM  : 2301974793
// ====================================================================================

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        int inputX = 0;
        System.out.println("");
        System.out.print("Masukkan nilai x: ");

        try {
            // Masukkan data yang diinput ke variable inputX. Jika data yang dimasukkan
            // bukan int, maka program akan 'jump' ke blok catch InputMismatchException.
            inputX = masukan.nextInt();

            if (inputX <= 0) {
                System.out.println("Nilai yang dimasukkan harus lebih besar dari 0.");
            }
        } catch (InputMismatchException ime) {
            // Blok ini akan dijalankan jika data yang diinput bukan berupa integer.
            System.out.println("Nilai yang dimasukkan harus bilangan bulat.");
        }

        if (inputX > 0) {
            HitungPangkat(inputX);
        }

        masukan.close();
        System.out.println("");
    }

    public static void HitungPangkat(int n) {
        // variable untuk menyimpan hasil perhitungan pangkat
        int hasilKali = 1;

        // lakukan perulangan sebanyak n kali untuk menghitung nilai pangkat
        for (int i = 0; i < n; i++) {
            hasilKali *= 2;
        }

        // hasil perhitungan pangkat dalam bentuk angka diubah ke bentuk array String
        String[] teksHasil = Integer.toString(hasilKali).split("");

        // Hasil perkalian dipecah dalam bentuk teks dan digabung dengan ' + '
        String jawaban = String.join(" + ", teksHasil);

        if (jawaban.startsWith("-")) {
            jawaban = "-" + jawaban.substring(4);
        }

        // Digunakan sebagai penanda apakah karakter yang pertama berupa tanda minus
        String penandaBilangan = "";

        // variable untuk menyimpan hasil perhitungan dari masing-masing character
        int jumlahHitung = 0;

        for (String s : teksHasil) {

            // Jika karakter berupa tanda minus, maka variable tandaMinus diisi dengan ' - '
            // dan perulangan berlanjut ke bagian berikutnya.
            if (s.equals("-")) {
                penandaBilangan = "-";
                continue;
            }

            // lakukan penjumlahan dari masing-masing String. Integer.parseInt(s)
            // digunakan untuk mengambil nilai int dari String s.
            jumlahHitung += Integer.parseInt(penandaBilangan + s);

            // Jika tandaMinus telah berisi, berarti sudah digunakan dan kemudian
            // dikosongkan
            if (penandaBilangan == "-") {
                penandaBilangan = "";
            }
        }

        // tampilkan hasil ke layar
        System.out.println("Hasil 2 pangkat " + n + " = " + hasilKali);
        System.out.println(jawaban + " = " + jumlahHitung);
    }
}
