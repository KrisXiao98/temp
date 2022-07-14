package Collection_Demo.LinkedList;

import java.util.LinkedList;

@SuppressWarnings({"all"})
public class CRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.add(i);
        }
        System.out.println("linkedlist" + linkedList);
    }
}


