import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner masukan = new Scanner(System.in);

        int nilai1, nilai2, nilaiTerbesar, nilaiTerkecil;
        
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

        System.out.println();
        System.out.println("Bilangan dengan nilai terbesar adalah : " + nilaiTerbesar);
        System.out.println("Bilangan dengan nilai terkecil adalah : " + nilaiTerkecil);
        System.out.println(nilai1 + " pangkat " + nilai2 + " adalah : " + (int)Math.pow(nilai1, nilai2));
        System.out.println(nilai1 + " kuadrat adalah : " + nilai1 * nilai1);
        System.out.println(nilai2 + " kuadrat adalah : " + nilai2 * nilai2);

        masukan.close();
    }
}
