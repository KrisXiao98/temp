package ExceptionDemo.Demo.HomeWork;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int num = myScanner.nextInt();
        do {
            try {
                System.out.println("num is " + num);
                break;
            } catch (Exception e) {
                System.out.println("输入格式不对，重新输入");
                continue;
            }
        }while (true);
    }
}