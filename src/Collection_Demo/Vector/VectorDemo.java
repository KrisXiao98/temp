package Collection_Demo.Vector;

import java.util.Vector;

@SuppressWarnings({"all"})
public class VectorDemo {
    public static void main(String[] args) {
        Vector vector = new Vector(8);
        for (int i = 0; i <= 7; i++) {
            vector.add(i);
        }
        vector.add(8);
        vector.add(11);
        System.out.println(vector);
    }
}
