package InterfaceProject;

public class Test {
    public static void main(String[] args) {
        System.out.println(IA.num);
        //IA.hi();
    }
}

interface IA {
    int num = 1;

    void hi();

}

class BBB implements IA {

    @Override
    public void hi() {
        System.out.println("aaa");
    }
}