package ThreadDemo.Exercise;


/*
要求：
1.主线程每隔1s，输出hi，一共10次
2.当输出hi 5 时，启动一个子线程（要求实现runnable），每隔1s输出hello，等待该线程输出10次hello后，退出
3.主线程继续输出hi，知道主线程退出
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        Thread thread = new Thread(thread01);
        int count = 0;
        while (count < 11){
            Thread.sleep(1000);
            System.out.println("主线程输出hi" + (++count)) ;
            if (count == 5){
                System.out.println("==========hi 5了，则启动子线程=========");
                thread.start();
                thread.join();//不start就无法join
                System.out.println("主线程继续运行");
            }
        }
        System.out.println("主线程结束");
    }
}

class Thread01 implements Runnable{

    private int count = 0;
    @Override
    public void run() {
        while (count < 11){
            try {
                Thread.sleep(1000);
                System.out.println("子线程输出hello" + (++count));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程结束====");
    }
}
