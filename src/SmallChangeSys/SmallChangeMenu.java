package SmallChangeSys;

import java.util.Scanner;

public class SmallChangeMenu {
    public static void main(String[] args) {
    //    零钱通界面显示
    //    接收用户输入
        Scanner myScanner = new Scanner(System.in);
        boolean isQuite = true;
        do{
            System.out.println("---------------零钱通菜单---------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退    出");

        //    switch方法流程控制
            System.out.print("请选择(1-4):");
            String key = myScanner.next();
            switch (key){
                case "1":
                    System.out.println("--------------------零钱通明细--------------------");
                    break;
                case "2":
                    System.out.println("收益入账");
                    break;
                case "3":
                    System.out.println("消费");
                    break;
                case "4":
                    System.out.println("退出");
                    isQuite = false;
                    break;
                default:
                    System.out.println("输入的信息有误，请检查");
            }
        }while (isQuite);
        System.out.println("-----已经退出零钱通系统-----");
    }
}
