package StringClass.StringDemo;

public class String02 {
    public static void main(String[] args) {
        String str1 = "hi";
        String str2 = new String("kai");
        System.out.println(str2.hashCode());
        str2 = "hello";
        System.out.println(str2.hashCode());
    }
}


class AAA {
    public final String num = "1111";
}

