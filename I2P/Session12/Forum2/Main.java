import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] kota = { "Serang", "Tangerang", "Palembang", "Lombok", "Halmahera", "Surabaya" };
        Arrays.stream(kota).sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::println);

        System.out.println();
        Arrays.stream(kota).forEach(System.out::println);
    }
}
