public class Main {

    public static void main(String[] args) {
        String value = "abc";
        String v2 = value;
        
        changeValue(value);
        
        System.out.println(value);
        value = "ddd";
        System.out.println(v2);
    }

    public static void changeValue(String a) {
        a = "xyz";
    }
}
