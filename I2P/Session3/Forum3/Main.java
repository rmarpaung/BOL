import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner masukan = new Scanner(System.in);
        float rupiah, dolar, euro;
        System.out.print("Masukan Rupiah = ");
        rupiah = masukan.nextFloat();
        dolar = (float) (rupiah*0.0001);
        euro = (float) (rupiah*0.00004);
        System.out.println();
        System.out.println("Hasil Kurs : ");
        System.out.println("Dolar \t= " + dolar);
        System.out.println("Euro \t= " + euro);

        // deklarasi variable untuk menyimpan nilai Yen, Ringgit, SGD, dan Yuan
        float yen, ringgit, sgd, yuan;

        yen = (float) (rupiah*0.0072);              // Pengisian nilai kalkulasi Yen
        ringgit = (float) (rupiah*0.00028);         // Pengisian nilai kalkulasi Ringgit
        sgd = (float) (rupiah*0.000092);            // Pengisian nilai kalkulasi SGD
        yuan = (float) (rupiah*0.00047);            // Pengisian nilai kalkulasi Yuan

        System.out.println("Yen \t= " + yen);       // Menampilkan kurs dalam Yen
        System.out.println("Ringgit = " + ringgit); // Menampilkan kurs dalam Ringgit
        System.out.println("SGD \t= " + sgd);       // Menampilkan kurs dalam SGD
        System.out.println("Yuan \t= " + yuan);     // Menampilkan kurs dalam Yuan
    }
}
