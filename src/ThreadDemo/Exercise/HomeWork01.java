package ThreadDemo.Exercise;


import java.util.Scanner;

/*
题目：
1.main方法中启动2个线程
2.第一个线程循环随机打印100以内的整数
3.直到第二个线程从键盘读取到了”Q“指令
 */
public class HomeWork01 {
    public static void main(String[] args) {
        Thread03 thread03 = new Thread03();
        thread03.setDaemon(true);//守护线程，比较简单
        thread03.start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("主线程--：请输入：");
            String input =  scanner.next();
            if (input.equals("Q") || input.equals("q")){
                //thread03.flag = false;
                break;
            }
        }
    }
}

class Thread03 extends Thread{
    boolean flag = true;
    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(1000);
                System.out.println((int)(Math.random() * 101));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}