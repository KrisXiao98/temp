package ThreadDemo;


//模拟线程死锁
public class DeadLockDemo {
    public static void main(String[] args) {
        //模拟死锁
        DeadLockTest A = new DeadLockTest(true);
        DeadLockTest B = new DeadLockTest(false);
        A.start();
        B.start();
    }
}

class DeadLockTest extends Thread {
    static Object o1 = new Object(); //为什么使用static和在DeadLockTest类中创建对象
    static Object o2 = new Object();//创建的这两个对象保证不管创建了多少个DeadLockTest对象，都使用的这2个对象。保证多线程，共享1个对象
    boolean flag;

    public DeadLockTest(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //分析
        //1.如果为真，线程会先得到 o1的对象锁，然后尝试获取o2的对象锁
        //2.如果线程A得不到o2 的对象锁，那么就会变成Block状态
        if (flag) {
            synchronized (o1) {//对象互斥锁。
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) {//这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}