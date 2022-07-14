package ExtendsProject;

public class Test {
    public static void main(String[] args) {
        PC pc = new PC();
        pc.setBrand("MacBook");
        NotePad notePad = new NotePad();
        notePad.setColor("yellow");
        pc.getDetails();
        notePad.getDetails();
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1.equals(str2));
    }
}
