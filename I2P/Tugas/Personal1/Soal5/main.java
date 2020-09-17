import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner masukan = new Scanner(System.in);

        int nilai1, nilai2, nilaiTerbesar, nilaiTerkecil, bilanganAcak;

        System.out.print("Masukkan bilangan a = ");
        nilai1 = masukan.nextInt();
        System.out.print("Masukkan bilangan b = ");
        nilai2 = masukan.nextInt();

        nilaiTerbesar = nilai1;
        nilaiTerkecil = nilai2;

        if (nilai1 < nilai2) {
            nilaiTerbesar = nilai2;
            nilaiTerkecil = nilai1;
        }

        bilanganAcak = (int) (Math.random() * (nilaiTerbesar - nilaiTerkecil) + nilaiTerkecil);

        System.out.println();
        System.out.println("nilai random : " + bilanganAcak);

        if (bilanganAcak % 2 == 0) {
            System.out.println("Hasil random bilangan Genap : " + bilanganAcak);
        } else {
            System.out.println("Hasil random bilangan Genap : " + (int)(bilanganAcak + 1));
        }

        masukan.close();
    }
}