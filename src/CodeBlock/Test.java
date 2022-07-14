package CodeBlock;

public class Test {
    public static void main(String[] args) {
        //A a = new A();
        //System.out.println(A.num);
        //System.out.println("===============");
        //System.out.println(a.age);
        B b = new B();
        System.out.println(B.num);
        System.out.println("===============");
        System.out.println(b.age);
    }
}

class A {
    static {
        System.out.println("A类的静态代码块2执行");
    }

    public int age = getAge();


    {
        System.out.println("A类的普通代码块2执行");
    }

    public A(int age) {
        this.age = age;
        System.out.println("A类的有参构造器被调用");
    }

    public static int num = getNum();

    public A() {
        System.out.println("A类的无参构造器被调用");
    }

    {
        System.out.println("A类的普通代码块1执行");
    }

    static {
        System.out.println("A类的静态代码块1执行");
    }


    public static int getNum() {
        System.out.println("A类的静态getNum方法被调用");
        return 100;
    }

    public int getAge() {
        System.out.println("A类的普通getAge方法被调用");
        return 20;
    }

}