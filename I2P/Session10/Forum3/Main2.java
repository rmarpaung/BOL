//===============================================================================================
// Nama       : Rimbun Marpaung
// NIM        : 2301974793
// Keterangan : Contoh kode untuk menangani exception ketika ada error yang terjadi pada program.
//===============================================================================================

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        String hasil = "";
        int x = 0, y = 0;
        boolean inputNilaiX = false, inputNilaiY = false;

        // Lakukan perulangan sampai nilai Y diisi. Pada saat inisialisasi, variable
        // inputNilaiY bernilai False, dan akan berubah menjadi True setelah nilai Y
        // dimasukkan.
        while (!inputNilaiY) {
            try {
                // Periksa apakah nilai X telah dimasukkan. Ini untuk mencegah agar masukan
                // untuk nilai X tidak diminta lagi pada perulangan berikutnya, dan hanya
                // dijalankan pada saat perulangan pertama saja.
                if (!inputNilaiX) {
                    System.out.print("Masukkan nilai x: ");

                    // Ubah nilai inputNilaiX menjadi True agar blok ini tidak dijalankan pada
                    // perulangan selanjutnya.
                    inputNilaiX = true;

                    // Masukkan data yang diinput ke variable x. Jika data yang dimasukkan bukan
                    // integer, maka program akan 'jump' ke blok catch InputMismatchException.
                    x = masukan.nextInt();
                }

                System.out.print("Masukkan nilai y: ");

                // Ubah nilai inputNilaiY menjadi True agar perulangan berhenti.
                inputNilaiY = true;

                // Masukkan data yang diinput ke variable y. Jika data yang dimasukkan bukan
                // integer, maka program akan 'jump' ke blok catch InputMismatchException. Jika
                // data yang dimasukkan 0, maka program akan 'jump' ke blok catch
                // ArithmeticException.
                y = masukan.nextInt();

                hasil = x + "/" + y + " = " + (x / y);
            } catch (InputMismatchException ime) {
                // Blok ini akan dijalankan jika data yang diinput bukan berupa integer.
                hasil += hasil == "" ? "Error: java.util.InputMismatchException" : "";
            } catch (ArithmeticException ae) {
                // Blok ini akan dijalankan jika variable y bernilai 0.
                hasil += hasil == "" ? "Error: java.util.ArithmeticException" : "";
            } catch (Exception nfe) {
                // Blok ini akan dijalankan kalau ada error selain dari dua blok catch di atas
                // (InputMismatchException dan ArithmeticException).
                hasil += hasil == "" ? "Error: java.util.Exception" : "";
            } finally {
                // Digunakan untuk "membuang" data masukan ketika error terjadi pada saat data
                // dimasukkan ke variable x
                masukan.nextLine();
            }
        }

        System.out.println(hasil);
        masukan.close();
    }
}
