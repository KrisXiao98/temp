package ThreadDemo.Exercise;

/*
题目：
1.有2个用户分别从同一个卡上取钱，总额10000
2.每次都取1000，当余额不足时，就不能再次取款了
3.不能出现超取现象
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Money money1 = new Money();
        Thread thread1 = new Thread(money1);
        Thread thread2 = new Thread(money1);
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}

class Money implements Runnable {

    private int balanceMoney = 10000;

    public void withDrawMoney(){
        synchronized (this){
            while (true){
                if (balanceMoney >= 1000){
                    balanceMoney -= 1000;
                    System.out.println(Thread.currentThread().getName() + "取走1000块，还剩下" + balanceMoney);
                }else {
                    System.out.println("不够取钱1000的了。");
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        withDrawMoney();
    }

}
