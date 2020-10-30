// Program pengurutan data
// Nama : Rimbun Marpaung
// NIM  : 2301974793

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner masukan = new Scanner(System.in);

    public static void main(String[] args) {
        int jumlahData = 0;
        System.out.println();

        while (jumlahData <= 0) {
            System.out.print("Masukkan jumlah data: ");
            try {
                jumlahData = masukan.nextInt();

                if (jumlahData <= 0) {
                    System.out.println("Nilai yang dimasukkan harus lebih besar dari 0.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Nilai yang dimasukkan harus bilangan bulat.");
                masukan.nextLine();
            }
        }
        ;

        String[][] dataMahasiswa = isiDataMahasiswa(jumlahData);
        String[][] dataSetelahDiUrut = urutkanData(dataMahasiswa);

        System.out.println();
        System.out.println("Data setelah diurut:");

        for (int i = 0; i < dataSetelahDiUrut.length; i++) {
            // System.out.println(Arrays.toString(dataSetelahDiUrut[i]));
            System.out.println((i + 1) + ". " + dataSetelahDiUrut[i][1]);
        }

        System.out.println();
        masukan.close();
    }

    private static String[][] isiDataMahasiswa(int jumlahData) {
        String[][] dataMahasiswa = new String[jumlahData][3];

        System.out.println("Masukkan data mahasiswa dengan format NIM<spasi>Nama<spasi>IPK: ");
        masukan.nextLine();

        for (int i = 0; i < jumlahData; i++) {
            boolean dataValid = false;

            while (!dataValid) {
                System.out.print((i + 1) + ". ");
                String data = masukan.nextLine();
                String[] detilData = data.split(" ");
                int jumlahDetilData = detilData.length;

                if (jumlahDetilData >= 3) {
                    String nim = detilData[0];

                    if (periksaNim(dataMahasiswa, nim)) {
                        System.out.println("NIM '" + nim + "' sudah digunakan oleh mahasiswa yang lain.");
                    } else {
                        String ipk = detilData[jumlahDetilData - 1];
                        String nama = data.substring(detilData[0].length() + 1, data.length() - ipk.length() - 1);
                        dataMahasiswa[i][0] = ipk;
                        dataMahasiswa[i][1] = nama;
                        dataMahasiswa[i][2] = nim;

                        dataValid = true;
                    }
                } else {
                    System.out.println("Data yang dimasukkan tidak sesuai format: NIM<spasi>Nama<spasi>IPK");
                }
            }
        }

        return dataMahasiswa;
    }

    private static boolean periksaNim(String[][] dataMahasiswa, String nim) {
        for (int i = 0; i < dataMahasiswa.length; i++) {
            if (dataMahasiswa[i][2] != null && dataMahasiswa[i][2].equals(nim)) {
                return true;
            }
        }

        return false;
    }

    private static String[][] urutkanData(String[][] dataMahasiswa) {
        for (int i = 0; i < dataMahasiswa.length; i++) {
            for (int j = 1; j < (dataMahasiswa.length - i); j++) {
                int compareIpk = dataMahasiswa[j - 1][0].compareToIgnoreCase(dataMahasiswa[j][0]);

                if (compareIpk == 0) {
                    int compareNama = dataMahasiswa[j - 1][1].compareToIgnoreCase(dataMahasiswa[j][1]);

                    if (compareNama == 0) {
                        int compareNim = dataMahasiswa[j - 1][2].compareToIgnoreCase(dataMahasiswa[j][2]);

                        if (compareNim > 0) {
                            tukarPosisi(dataMahasiswa, j);
                        }
                    } else if (compareNama < 0) {
                        tukarPosisi(dataMahasiswa, j);
                    }
                } else if (compareIpk < 0) {
                    tukarPosisi(dataMahasiswa, j);
                }
            }
        }

        return dataMahasiswa;
    }

    private static void tukarPosisi(String[][] arrData, int position) {
        String[] dataSementara = new String[3];

        dataSementara = arrData[position - 1];
        arrData[position - 1] = arrData[position];
        arrData[position] = dataSementara;
    }
}
