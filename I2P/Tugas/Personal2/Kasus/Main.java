//  Program Pendataan Mata Kuliah
//  By: [YourName]
//  Date: [CreatedDate]
//  Desc: Permainan tebak angka. User menebak angka hingga benar.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<ArrayList<Object>> dataMataKuliah = new ArrayList<>();
    static ArrayList<String> gradeValid = new ArrayList<>(List.of("E", "e", "D", "d", "C", "c", "B", "b", "A", "a"));
    static final String SEPARATOR = "-------------------------------------------------------";

    public static void main(String[] args) {
        int pilihanMenu;

        do {
            pilihanMenu = 0;
            tampilkanMenu();
            System.out.print("Masukkan pilihan: ");

            try {
                pilihanMenu = input.nextInt();
            } catch (InputMismatchException ime) {
                input.nextLine();
            }

            if (pilihanMenu == 1) {
                pendataanMataKuliah();
            } else if (pilihanMenu == 2) {
                perhitunganIps();
            } else if (pilihanMenu == 3) {
                updateGrade();
            }

        } while (pilihanMenu != 4);

        input.close();
    }

    private static void tampilkanMenu() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("Pendataan dan Perhitugan IPS (Indeks Prestasi Semester)");
        System.out.println("1. Pendataan Matakuliah");
        System.out.println("2. Perhitungan IPS");
        System.out.println("3. Update Grade");
        System.out.println("4. Keluar ");
        System.out.println(SEPARATOR);
    }

    private static void pendataanMataKuliah() {
        System.out.println();
        System.out.println();
        System.out.println("1. Pendataan Mata Kuliah");
        System.out.println(SEPARATOR);

        int jumlahMataKuliah;

        do {
            jumlahMataKuliah = 0;
            System.out.print("Masukkan jumlah mata kuliah (1 sampai 10): ");

            try {
                jumlahMataKuliah = input.nextInt();
            } catch (InputMismatchException ime) {
                input.nextLine();
            }

        } while (jumlahMataKuliah < 1 || jumlahMataKuliah > 10);

        System.out.println();

        simpanMataKuliah(jumlahMataKuliah);
    }

    private static void simpanMataKuliah(int jumlahMataKuliah) {
        String kodeMataKuliah;
        String namaMataKuliah;
        String grade;
        int jumlahSks;

        for (int i = 0; i < jumlahMataKuliah; i++) {
            input.nextLine();
            System.out.println("Mata Kuliah " + (i + 1));

            do {
                System.out.print("Masukkan kode mata kuliah: ");
                kodeMataKuliah = input.nextLine();

                if (!periksaMataKuliahTersedia(kodeMataKuliah)) {
                    System.out.println("Kode mata kuliah sudah dipakai, silakan gunakan kode yang lain.");
                }
            } while (!periksaMataKuliahTersedia(kodeMataKuliah));

            System.out.print("Masukkan nama mata kuliah: ");
            namaMataKuliah = input.nextLine();

            do {
                grade = "";

                System.out.print("Masukkan grade mata kuliah: ");
                grade = input.nextLine();

                if (!gradeValid.contains(grade)) {
                    System.out.println("Grade yang dapat digunakan hanya salah satu dari A, B, C, D, atau E.");
                }
            } while (!gradeValid.contains(grade));

            do {
                jumlahSks = 0;
                System.out.print("Masukkan jumlah SKS (1 sampai 6): ");

                try {
                    jumlahSks = input.nextInt();
                } catch (InputMismatchException ime) {
                    input.nextLine();
                }

            } while (jumlahSks < 1 || jumlahSks > 6);

            ArrayList<Object> mataKuliah = new ArrayList<>(4);

            mataKuliah.add(kodeMataKuliah);
            mataKuliah.add(namaMataKuliah);
            mataKuliah.add(grade);
            mataKuliah.add(jumlahSks);

            dataMataKuliah.add(mataKuliah);

            System.out.println();
        }
    }

    private static boolean periksaMataKuliahTersedia(String kodeMataKuliah) {
        for (ArrayList<Object> mataKuliah : dataMataKuliah) {
            if (mataKuliah.get(0).equals(kodeMataKuliah)) {
                return false;
            }
        }

        return true;
    }

    private static void perhitunganIps() {
        System.out.println();
        System.out.println();
        System.out.println("2. Perhitungan IPS");
        System.out.println(SEPARATOR);
        System.out.println("Mata kuliah yang Anda ambil adalah:");

        int totalSks = 0;
        int totalGrade = 0;
        int sks;
        int nilaiGrade;

        for (ArrayList<Object> mataKuliah : dataMataKuliah) {
            sks = (int) mataKuliah.get(3);
            nilaiGrade = gradeValid.indexOf(mataKuliah.get(2)) / 2;

            totalSks += sks;
            totalGrade += sks * nilaiGrade;

            System.out.println(mataKuliah.get(0) + "\t" + mataKuliah.get(1) + "\t"
                    + mataKuliah.get(2).toString().toUpperCase() + "\t" + sks);
        }

        float nilaiIps = totalSks == 0 ? 0 : (float) totalGrade / (float) totalSks;
        System.out.println("Nilai IPS Anda adalah: " + nilaiIps);

        input.nextLine();
    }

    private static void updateGrade() {
        System.out.println();
        System.out.println();
        System.out.println("3. Update Grade");
        System.out.println(SEPARATOR);

        input.nextLine();
        System.out.print("Masukkan kode mata kuliah: ");

        String kodeMataKuliah = input.nextLine();
        ArrayList<Object> mataKuliahDipilih = null;

        for (ArrayList<Object> mataKuliah : dataMataKuliah) {
            if (mataKuliah.get(0).equals(kodeMataKuliah)) {
                mataKuliahDipilih = mataKuliah;
                break;
            }
        }

        if (mataKuliahDipilih == null) {
            System.out.println("Mata kuliah tidak ditemukan.");
        } else {
            String grade;

            do {
                System.out.print("Masukkan grade baru (A, B, C, D, E): ");
                grade = input.nextLine();
            } while (!gradeValid.contains(grade));

            mataKuliahDipilih.set(2, grade);

            for (ArrayList<Object> mataKuliah : dataMataKuliah) {
                System.out.println(mataKuliah.get(0) + "\t" + mataKuliah.get(1) + "\t"
                        + mataKuliah.get(2).toString().toUpperCase() + "\t" + mataKuliah.get(3));
            }
        }
    }
}
