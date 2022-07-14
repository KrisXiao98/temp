package CodeBlock;

public class B extends A{
    static {
        System.out.println("B类的静态代码块2执行");
    }

    public int age = getAge();


    {
        System.out.println("B类的普通代码块2执行");
    }

    public B(int age) {
        this.age = age;
        System.out.println("B类的有参构造器被调用");
    }

    public static int num = getNum();

    public B() {
        System.out.println("B类的无参构造器被调用");
    }

    {
        System.out.println("B类的普通代码块1执行");
    }

    static {
        System.out.println("B类的静态代码块1执行");
    }


    public static int getNum() {
        System.out.println("B类的静态getNum方法被调用");
        return 105;
    }

    public int getAge() {
        System.out.println("B类的普通getAge方法被调用");
        return 25;
    }
}
