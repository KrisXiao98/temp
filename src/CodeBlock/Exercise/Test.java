package CodeBlock.Exercise;

public class Test extends Sample{
    public static void main(String[] args) {
        Test test = new Test();
    }
    Sample sam1 = new Sample("Sam1成员初始化");
    static Sample sam = new Sample("静态成员成员初始化");
    static {
        System.out.println("static块执行");
        if(sam == null){
            System.out.println("sam is null");
        }
    }
    Test(){
        System.out.println("Test默认构造器函数被调用");
    }
}
