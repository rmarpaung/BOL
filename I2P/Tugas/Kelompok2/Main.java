import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nama;
        int tahunLahir;

        Scanner masukan = new Scanner(System.in);

        System.out.print("Masukkan nama Anda: ");
        nama = masukan.nextLine();

        System.out.print("Masukkan tahun lahir Anda: ");

        // Pemeriksaan apakah data yang dimasukkan dalam bentuk angka
        try {
            tahunLahir = masukan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Tahun lahir yang dimasukkan hanya bisa berupa bilangan bulat saja.");
            masukan.close();
            return;
        }

        // Pemeriksaan tahun lahir yang dimasukkan harus dalam rentang 100 tahun
        LocalDate now = LocalDate.now();
        int tahunSaatIni = now.getYear();
        int tahunAwal = tahunSaatIni - 100;
        int tahunAkhir = tahunSaatIni - 1;

        // Jika tahun lahir yang dimasukkan lebih kecil dari 100 tahun atau lebih besar
        // dari tahun kemarin maka munculkan pesan
        if (tahunLahir < tahunAwal || tahunLahir > tahunAkhir) {
            System.out.println("Tahun lahir yang dimasukkan harus dalam rentang dari tahun " + tahunAwal + " sampai "
                    + tahunAkhir + ".");
        } else {
            // Hitung usia
            int usia = tahunSaatIni - tahunLahir;
            String pesan = "";

            // Buat penggabungan kalimat yang sesuai dengan usia
            if (usia >= 21) {
                pesan += " dan 21+";
            }
            if (usia >= 17) {
                pesan = pesan.length() > 0 ? ", 17+" + pesan : " dan 17+";
            }
            if (usia >= 13) {
                pesan = pesan.length() > 0 ? ", 13+" + pesan : " dan 13+";
            }

            pesan = "SU" + pesan;

            // Tampilkan pesan ke layar.
            if (usia < 13) {
                System.out.println("Adik " + nama + ", berusia " + usia
                        + " tahun, hanya dapat menonton film dengan klasifikasi " + pesan);
            } else {
                System.out.println(
                        nama + ", Anda berusia " + usia + " tahun, dapat menonton film dengan klasifikasi " + pesan);
            }
        }

        masukan.close();
    }
}
