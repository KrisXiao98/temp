package ThreadDemo;

public class Demo03 {
    public static void main(String[] args) {
        int count = 0;
        Test test = new Test();
        test.setName("子线程");
        test.setPriority(Thread.MIN_PRIORITY);
        test.start();
        while (count <= 20) {
            try {
                Thread.sleep(1000);
                System.out.println("主线程每隔1s输出hi" + "hi" + (++count));
                if(count == 5){
                    System.out.println("主线程输出5个了，让子线程输出");
                    //test.join();
                    Thread.yield();
                    System.out.println("子线程输出完了，主线程才能接着运行");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Test extends Thread {
    private int count;

    @Override
    public void run() {
        while (count <= 20) {
            try {
                Thread.sleep(1000);
                System.out.println("线程名：" + this.getName() + "每隔1s输出hello" + (++count));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}