import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nilai;
        Scanner masukan = new Scanner(System.in);

        System.out.print("Masukkan nilai (0 - 100): ");

        try {
            nilai = masukan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Data yang dimasukkan hanya bisa berupa bilangan bulat saja.");
            masukan.close();
            return;
        }

        if (nilai >= 0 && nilai <= 100) {
            System.out.println(nilai > 75 ? "Lulus" : "Tidak Lulus");
        } else {
            System.out.println("Data yang dimasukkan harus dalam rentang 0 sampai 100.");
        }

        masukan.close();
    }
}
