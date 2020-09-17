import java.util.Scanner;
 
public class Main2 {
 
    public static void main(String[] args) {
        // Input
        int random, tebak, jumlah;
        random = (int) (Math.random() * 100);
        System.out.println("Tebaklah Angka Antara 1-100");
        Scanner masukan = new Scanner(System.in);
        jumlah = 0;
 
        // Proses
        do {
            jumlah++;
            System.out.print("Masukkan Tebakan Anda (" + jumlah + ") : ");
            tebak = masukan.nextInt();
 
            //Output
            if (tebak > random) {
                System.out.println("Tebakan Terlalu Besar");
            } else if (tebak < random) {
                System.out.println("Tebakan Terlalu Kecil");
            } else {
                System.out.print("Tebakan Benar! Setelah " + jumlah + " Kali Menebak");
            }
            
            // Lakukan pemeriksaan apakah tebakan telah dilakukan sebanyak 5 kali dan masih belum benar
            if (jumlah == 5 && tebak != random) {
                // Jika masuk ke dalam blok ini berarti tebakan telah salah 5 kali, 
                // dan selanjutnya tampilkan jawaban yang benar
                System.out.println("---------------------------------------------------------");
                System.out.println("Tebakan telah 5 kali salah. Jawaban yang benar adalah: " + random);
                break;      // keluar dari perulangan
            }            
        } while (tebak != random);
    }
}