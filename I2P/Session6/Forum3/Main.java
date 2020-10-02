import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        String kalimat = "";
        String hasil = "COOL";
        int panjangKalimat = 0;

        System.out.print("Masukkan kalimat: ");

        // Masukkan data yang diinput ke variable kalimat
        kalimat = masukan.nextLine();       

        // Ambil jumlah karakter yang diinput
        panjangKalimat = kalimat.length();  
        
        // Periksa apakah ada data yang diinput. Jika tidak ada maka tampilkan pesan dan
        // program berakhir.
        if (panjangKalimat == 0) {
            System.out.println("Anda belum memasukkan kalimat. Silakan diulang kembali.");
            masukan.close();
            return;
        }

        // Bandingkan karakter per karakter dimulai dari karakter pertama sampai
        // karakter terakhir. Jika karakter pertama sama dengan karakter terakhir, maka
        // pemeriksaan berlanjut ke karakter kedua dari awal untuk dibandingkan dengan
        // karakter kedua dari akhir, dan seterusnya. Jika tidak sama, maka perulangan
        // berakhir (break).
        for (int x = 0; x < panjangKalimat; x++) {
            // jika karakter tidak sama, maka perulangan berakhir dan variable hasil
            // diberi nilai "BAD".
            if (kalimat.charAt(x) != kalimat.charAt(panjangKalimat - 1 - x)) {
                hasil = "BAD";
                break;
            }
        }

        System.out.println(hasil);
        masukan.close();
    }
}
