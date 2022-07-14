package InnerClass.LocalInnerClass;

public class Demo {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.function01();// 这里就是5的使用，只能通过外部类的成员方法来执行
        System.out.println(outer01);//outer.this其实就是outer（）
    }
}


class Outer01 {//外部类
    private int num1 = 1;

    private void setNum1(int n) {
        String age = "Sam";//局部变量是不能加修饰符的
        num1 = n;
        System.out.println("num1更改后变为：" + num1);
    }
    //3. 局部内部类可以定义在代码块中
    {
        class Inner02 {
            public void hi() {
                System.out.println("hi()");
            }
        }
    }

    public void function01() {
        //局部内部类定义在外部类的局部位置，通常在方法或者代码块中
        //2. 不能加访问修饰符，但是可以用final，本质上也是个类，可以有自己的成员。final的作用就是不希望被继承，但是可以创建实例。
        class Inner01 {
            private String name = "Kris";
            private int num1 = 25;
            public void printNum() {
                //1. 可以直接访问外部类的所有成员，包含私有的成员
                System.out.println("num1=" + num1);//4.局部内部类访问外部类的成员是直接访问
                setNum1(100);
                //7. 访问外部的同名属性。Outer01.this的作用相当于Outer()
                System.out.println("访问外部类的同名的num1，使用类名.this.属性 " + Outer01.this.num1);
                System.out.println("Outer01.this = " + Outer01.this);
            }
        }
        //5.外部类访问局部内部类的成员，在作用域内访问内部成员
        Inner01 inner01 = new Inner01();
        inner01.printNum();
    }

}