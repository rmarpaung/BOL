import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        String nomorHp;
        String pesan = "";
        int kalkulasi = 0;
        int panjangNomor = 0;

        System.out.print("Masukkan nomor handphone Anda: ");

        nomorHp = masukan.nextLine().trim();
        panjangNomor = nomorHp.length();

        if (panjangNomor > 13) {
            System.out.println("Nomor yang dimasukkan terlalu panjang, maksimal 13 karakter");
        } else if (panjangNomor < 10) {
            System.out.println("Nomor yang dimasukkan terlalu pendek, minimal 10 karakter");
        } else {
            for (int i = 0; i < panjangNomor; i++) {
                char karakter = nomorHp.charAt(i);

                if (!Character.isDigit(karakter)) {
                    System.out.println(
                            "Nomor yang dimasukkan mengandung karakter yang bukan angka. Silakan dicoba kembali.");
                    masukan.close();
                    return;
                }

                kalkulasi += (int) karakter;
                pesan += karakter;

                if (i < panjangNomor - 1) {
                    pesan += " + ";
                }
            }

            System.out.println(pesan + " = " + kalkulasi);
        }

        masukan.close();
    }
}