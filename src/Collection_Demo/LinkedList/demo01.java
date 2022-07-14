package Collection_Demo.LinkedList;

public class demo01 {
    public static void main(String[] args) {
        //模拟双向链表,创建三个节点
        Node kris = new Node("Kris");
        Node smith = new Node("Smith");
        Node saber = new Node("Saber");

        //进行双向链接，kris的next指向smith。注意不是指向smith的next。依次类推
        kris.next = smith;
        smith.next = saber;
        saber.pre = smith;
        smith.pre = kris;

        //指定链表的头部和尾部
        Node first = kris;
        Node last = saber;

        System.out.println("===从头到尾===");
        //遍历出双向链表的所有数据，从头到尾
        while (true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }

        System.out.println("===从尾到头==");
        //遍历出双向链表的所有数据，从尾到头
        while (true){
            if(last == null){
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        //在smith后面插入一个Jack
        Node jack = new Node("Jack");
        smith.next = jack;
        jack.next = saber;
        saber.pre = jack;
        jack.pre = smith;

        first = kris;
        last = saber;
        System.out.println("===插入jack后的从头到尾===");
        //遍历出双向链表的所有数据，从头到尾
        while (true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }

    }
}

//定义一个Node类，Node 对象 表示双向链表的一个节点
class Node{
    public Object item;//存放真正的数据。为什么是Object类型的？存放的真正数据可能有很多种类型，他们都是Object类型的子类，所以最好用这个
    public Node next;//指向下一个节点。为什么是Node类型的？不一定非的是Node对象。在这里。不难想象，你next指向的下一个对象是一个Node的对象。
    public Node pre;//指向后一个节点
    public Node(String name){
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name=" + item;
    }
}

