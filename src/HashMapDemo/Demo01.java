package HashMapDemo;

public class Demo01 {
    public static void main(String[] args) {
        //模拟一个HashSet的底层（实际就是HashMap）
        //1.创建一个数组，数组的类型是Node[]
        //2.有些人直接把Node数组称为table（表）
        Node[] table = new Node[16];
        System.out.println("table" + table);
        //3.创建节点
        Node john = new Node("John", null);

        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;//将jack节点挂载到john后

        Node rose = new Node("Rose", null);
        jack.next = rose;//将rose节点挂载到jack后，到这里，table的第三位含有一个3个长度的单项链表

        Node lucy = new Node("Lucy", null);
        table[3] = lucy;//把lucy放在table表的索引3处

        System.out.println("table" + table);

        System.out.println(table[2].next);


    }
}


class Node{
    //节点，存储数据，可以指向下一个节点，从而形成链表
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
