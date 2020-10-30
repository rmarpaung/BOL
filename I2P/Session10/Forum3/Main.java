//===============================================================================================
// Nama       : Rimbun Marpaung
// NIM        : 2301974793
// Keterangan : Contoh kode untuk menangani exception ketika ada error yang terjadi pada program.
//===============================================================================================

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        String hasil = "";
        int x = 0, y = 0;

        try {
            System.out.print("Masukkan nilai x: ");

            // Masukkan data yang diinput ke variable x. Jika data yang dimasukkan bukan
            // integer, maka program akan 'jump' ke blok catch InputMismatchException.
            x = masukan.nextInt();
        } catch (InputMismatchException ime) {
            // Blok ini akan dijalankan jika data yang diinput bukan berupa integer.
            hasil += hasil == "" ? "Error: java.util.InputMismatchException" : "";

            // Digunakan untuk "membuang" data masukan ketika error terjadi pada saat data
            // dimasukkan ke variable x
            masukan.nextLine();
        }

        try {
            System.out.print("Masukkan nilai y: ");

            // Masukkan data yang diinput ke variable y. Jika data yang dimasukkan bukan
            // integer, maka program akan 'jump' ke blok catch InputMismatchException. Jika
            // data yang dimasukkan 0, maka program akan 'jump' ke blok catch
            // ArithmeticException.
            y = masukan.nextInt();

            hasil += hasil == "" ? x + "/" + y + " = " + (x / y) : "";
        } catch (InputMismatchException ime) {
            // Blok ini akan dijalankan jika data yang diinput bukan berupa integer.
            hasil += hasil == "" ? "Error: java.util.InputMismatchException" : "";
        } catch (ArithmeticException ae) {
            // Blok ini akan dijalankan jika variable y bernilai 0.
            hasil += hasil == "" ? "Error: java.util.ArithmeticException" : "";
        }

        System.out.println(hasil);
        masukan.close();
    }
}
