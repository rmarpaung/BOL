import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nilai;
        Scanner masukan = new Scanner(System.in);

        System.out.print("Masukkan angka 1 - 100: ");

        // Pemeriksaan apakah data yang dimasukkan berupa angka bilangan bulat
        try {
            nilai = masukan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Data yang dimasukkan hanya bisa berupa bilangan bulat saja.");
            masukan.close();
            return;
        }

        // Pemeriksaan data yang dimasukkan harus dalam rentang dari 1 sampai 100
        // Jika di bawah 1 atau di atas 100, maka program akan menampilkan pesan dan program akan berhenti.
        if (nilai < 1 || nilai > 100) {
            System.out.println("Data yang dimasukkan harus dalam rentang dari 1 sampai 100.");
        } else {            
            if (nilai % 2 != 0) {                           // Jika data yang dimasukkan berupa bilang ganjil, 
                System.out.println("AJAIB");                // maka program menampilkan pesan 'AJAIB'
            } else {
                if (nilai > 20) {                           // Jika data yang dimasukkan bilangan genap dan lebih besar dari 20,
                    System.out.println("Tidak AJAIB");      // maka program akan menampilkan pesan 'Tidak AJAIB'
                } else if (nilai > 6) {                     // Jika data yang dimasukkan bilangan genap antara 6 dan 20,
                    System.out.println("AJAIB");            // maka program akan menampilkan pesan 'AJAIB'
                } else {                                    // Jika data yang dimasukkan bilangan genap antara 2 dan 5,
                    System.out.println("Tidak AJAIB");      // maka program akan menampilkan pesan 'Tidak AJAIB'
                }
            }
        }

        masukan.close();
    }
}
