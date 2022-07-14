package InnerClass.AnonymousInnerClass;

public class ZuiJiaShiJian {
    public static void main(String[] args) {
        f1(new IA(){
            @Override
            public void say() {
                System.out.println("say hello");
            }
        });
    }

    //静态方法，形参是接口类型
    public static void f1(IA ia){
        ia.say();
    }
}


interface IA{
    void say();
}