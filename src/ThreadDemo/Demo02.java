package ThreadDemo;

public class Demo02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //这里不能调用start.这里底层使用了设计模式（代理模式）
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable{

    int count = 0;
    @Override
    public void run() {
        while (count >= 10){
            System.out.println("hello" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

