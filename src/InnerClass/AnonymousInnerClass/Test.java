package InnerClass.AnonymousInnerClass;

public class Test {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.method();
    }
}

class Outer02 {//编写一个外部类
    private int n1 = 10;

    public void method() {//匿名内部类还是放在方法中或者代码块中的，它的本质也还是一个类
        //1.使用场景：简化开发，当你想要创建一个类来实现接口的时候，这个类你只使用一次，因此没有必要再定义很多相关的类来实现接口
        //  这个时候就可以使用匿名内部类,比如下方的animal接口，你想再method方法中只实现一次cry()方法，就不必在外部创建实现它的很多接口实现类
        //  比如tiger、dog等
        //2.那么现在使用匿名内部类,注意次类依然可以创建构造器等。
        //3.tiger的编译类型：Animal
        //4.tiger的运行类型：其实就是这个匿名内部类，只使用一次，后面再不使用-》它的底层就是Outer02$1
        //5.我的理解：Animal() = jdk自己创建的Outer02$1。 即 Animal tiger = new Animal() 变成 Animal tiger = new Outer02$1()
        //底层就是分配类名 Outer02$1 这个类只会运行一次
        /*
         *class Outer02$1 implements Animal{
         *     public void cry(){
         *    }
         *}
         */
        Animal tiger = new Animal() {
            @Override
            public void cry() {
                System.out.println("tiger叫唤。。。。");
            }
        };
        tiger.cry();
        System.out.println("tiger的运行类型" + tiger.getClass());
    }
}

interface Animal {
    void cry();
}