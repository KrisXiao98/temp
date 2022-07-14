package ThreadDemo;

public class Demo01 {
    public static void main(String[] args) {
        //创建Cat对象，当作线程使用
        Cat cat = new Cat();
        cat.start();//启动线程


    }
}

//编写一个线程，该线程每隔1秒，在控制台输出“喵喵，我是小猫咪”
//当输出80次，结束线程，使用JConsole监控线程执行情况

//当一个类继承了Thread类，该类就可以当作线程使用
class Cat extends Thread {
    int times = 0;

    @Override
    public void run() {
        while (times < 20) {
            //重写run方法，实现自己的逻辑，run方法是实现了Runnable接口的run方法
            System.out.println("喵喵，我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}