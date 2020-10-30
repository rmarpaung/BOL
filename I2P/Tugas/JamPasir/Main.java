import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        int[][] matriks = new int[6][6];
        String[][] jamPasir = new String[4][4];

        for (int i = 0; i < 6; i++) {

            String input;

            do {
                System.out.print("Masukkan 6 digit baris ke-" + (i + 1) + " : ");

                input = masukan.nextLine();

                if (input.length() == 6) {
                    try {
                        for (int j = 0; j < 6; j++) {
                            matriks[i][j] = Integer.valueOf(input.substring(j, j + 1));
                        }

                        continue;
                    } catch (NumberFormatException nfe) {
                        input = "";
                    }
                }

                System.out.println("Input harus berupa 9 digit angka.");

            } while (input.length() != 6);
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }

        int angkaTerbesar = 0;
        int posisiTerbesarX = 0;
        int posisiTerbesarY = 0;

        System.out.println();
        System.out.println("Matriks yang diinput:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int total = matriks[i][j] + matriks[i][j + 1] + matriks[i][j + 2] + matriks[i + 1][j + 1]
                        + matriks[i + 2][j] + matriks[i + 2][j + 1] + matriks[i + 2][j + 2];

                if (total > angkaTerbesar) {
                    angkaTerbesar = total;
                    posisiTerbesarX = i;
                    posisiTerbesarY = j;
                }

                jamPasir[i][j] = matriks[i][j] + " " + matriks[i][j + 1] + " " + matriks[i][j + 2] + " \n  "
                        + matriks[i + 1][j + 1] + " \n" + matriks[i + 2][j] + " " + matriks[i + 2][j + 1] + " "
                        + matriks[i + 2][j + 2];
            }
        }

        System.out.println();
        System.out.println("Jam pasir terbesar adalah: ");
        System.out.println(jamPasir[posisiTerbesarX][posisiTerbesarY]);
        System.out.println();
        System.out.println("Total: " + angkaTerbesar);
        System.out.println();

        masukan.close();
    }
}
