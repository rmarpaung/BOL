import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] deretAngka = { 4, 3, 5, 2, 9, 6 };
        int[] deretBaru = deretAngka.clone();

        for (int i = 0; i < deretBaru.length - 1; i++) {
            int posisiAngkaTerkecil = i;
            int nilaiAngkaTerkecil = deretBaru[i];

            for (int j = i + 1; j < deretBaru.length; j++) {
                if (nilaiAngkaTerkecil > deretBaru[j]) {
                    nilaiAngkaTerkecil = deretBaru[j];
                    posisiAngkaTerkecil = j;
                }
            }

            if (posisiAngkaTerkecil != i) {
                deretBaru[posisiAngkaTerkecil] = deretBaru[i];
                deretBaru[i] = nilaiAngkaTerkecil;
            }
        }

        System.out.println(Arrays.toString(deretAngka));
        System.out.println(Arrays.toString(deretBaru));
    }

    // public static void main(String[] args) {
    // int[] deretAngka = { 4, 3, 5, 2, 9, 6 };
    // int[] deretBaru = deretAngka.clone();
    // int dataSementara = 0;

    // for (int i = 0; i < deretBaru.length; i++) {
    // for (int j = 1; j < (deretBaru.length - i); j++) {
    // if (deretBaru[j - 1] > deretBaru[j]) {
    // // tukar posisi
    // dataSementara = deretBaru[j - 1];
    // deretBaru[j - 1] = deretBaru[j];
    // deretBaru[j] = dataSementara;
    // }
    // }
    // }

    // System.out.println();
    // System.out.println("BUBBLE SORT");
    // System.out.print("Deret Angka: ");
    // System.out.println(Arrays.toString(deretAngka));
    // int[] hasilBubbleSort = bubbleSort(deretAngka.clone());

    // System.out.println();
    // System.out.println("INSERTION SORT");
    // System.out.print("Deret Angka: ");
    // System.out.println(Arrays.toString(deretAngka));
    // int[] hasilInsertionSort = insertionSort(deretAngka.clone());

    // System.out.println();
    // System.out.println("SELECTION SORT");
    // System.out.print("Deret Angka: ");
    // System.out.println(Arrays.toString(deretAngka));
    // int[] hasilSelectionSort = selectionSort(deretAngka.clone());
    // }

    private static int[] bubbleSort(int[] deretAngka) {
        int dataSementara = 0;
        for (int i = 0; i < deretAngka.length; i++) {
            for (int j = 1; j < (deretAngka.length - i); j++) {
                if (deretAngka[j - 1] > deretAngka[j]) {
                    // swap elements
                    dataSementara = deretAngka[j - 1];
                    deretAngka[j - 1] = deretAngka[j];
                    deretAngka[j] = dataSementara;
                }
                System.out.println("[" + i + ", " + j + "] " + Arrays.toString(deretAngka));
            }
        }

        return deretAngka;
    }

    private static int[] insertionSort(int[] deretAngka) {
        for (int i = 1; i < deretAngka.length; i++) {
            /**
             * Insert list[i] into a sorted sublist list[0..i-1] so that list[0..i] is
             * sorted.
             */
            int currentElement = deretAngka[i];
            int j;

            for (j = i - 1; j >= 0 && deretAngka[j] > currentElement; j--) {
                deretAngka[j + 1] = deretAngka[j];
            }

            deretAngka[j + 1] = currentElement;
            System.out.println(Arrays.toString(deretAngka));
        }

        return deretAngka;
    }

    private static int[] selectionSort(int[] deretAngka) {
        for (int i = 0; i < deretAngka.length - 1; i++) {
            int posisiAngkaTerkecil = i;
            int nilaiAngkaTerkecil = deretAngka[i];

            for (int j = i + 1; j < deretAngka.length; j++) {
                if (nilaiAngkaTerkecil > deretAngka[j]) {
                    nilaiAngkaTerkecil = deretAngka[j];
                    posisiAngkaTerkecil = j;
                }
            }

            if (posisiAngkaTerkecil != i) {
                deretAngka[posisiAngkaTerkecil] = deretAngka[i];
                deretAngka[i] = nilaiAngkaTerkecil;
            }
            System.out.println(Arrays.toString(deretAngka));
        }

        return deretAngka;
    }

}
