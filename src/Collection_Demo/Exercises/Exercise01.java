package Collection_Demo.Exercises;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list01 = new ArrayList();
        list01.add("hello1");
        list01.add("hello2");
        list01.add("hello3");
        list01.add("hello4");
        list01.add("hello5");
        list01.add("hello6");
        list01.add("hello7");
        list01.add("hello8");
        list01.add("hello9");
        list01.add("hello10");
        list01.add(1, "hspedu");
        Object obj01 = list01.get(4);
        System.out.println(obj01);
        list01.remove(5);
        list01.set(6, "Kris");
        Iterator iterator = list01.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}

