package ThreadDemo.Exercise;


/*
需求：
1.编程模拟售票系统，三个售票窗口售票总共100张，分别使用继承Thread和实现Runnable接口的方式来实现
 */
public class SellTicket {


    public static void main(String[] args) {

        //TicketWindow ticketWindow1 = new TicketWindow();
        //TicketWindow ticketWindow2 = new TicketWindow();
        //TicketWindow ticketWindow3 = new TicketWindow();
        //ticketWindow1.start();
        //ticketWindow2.start();
        //ticketWindow3.start();


        //使用runnable的方式，还是会出现超卖。
        TicketWindow02 ticketWindow02 = new TicketWindow02();
        Thread thread1 = new Thread(ticketWindow02);
        Thread thread2 = new Thread(ticketWindow02);
        Thread thread3 = new Thread(ticketWindow02);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class TicketWindow extends Thread {

    public static int ticketNum = 100;

    public boolean selectNum() {
        if (ticketNum <= 0) {
            System.out.println("卖完了");
            return false;
        }
        return true;
    }


    @Override
    public synchronized void run() {
        while (selectNum()) {
            try {
                Thread.sleep(100);
                System.out.println("现在执行线程=" + Thread.currentThread().getName() + " 剩余票数=" + (--ticketNum));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//实现接口的方式
class TicketWindow02 implements Runnable {

    public static int ticketNum = 100;

    public boolean selectNum() {
        if (ticketNum <= 0) {
            System.out.println("卖完了");
            return false;
        }
        return true;
    }

    @Override
    public synchronized void run() {
        while (selectNum()) {
            try {
                Thread.sleep(100);
                System.out.println("现在执行线程=" + Thread.currentThread().getName() + " 剩余票数=" + (--ticketNum));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

