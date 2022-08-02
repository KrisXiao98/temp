package QQCommunication.QQClient.QQCommon;


import QQCommunication.QQClient.QQService.UserClientService;

import java.util.Scanner;

//客户端菜单显示
public class QQView {


    public static void main(String[] args) {
        new QQView().QQMainView();
    }

    //退出系统或者进入系统标志位
    private boolean loop = true;

    //接受用户输入
    private final Scanner myScanner = new Scanner(System.in);
    private String key;

    //保存userID和pwd供其他模块调用
    private String userID;
    private String pwd;

    public  void QQMainView(){
        while (loop){
            System.out.println("==========欢迎登录网络通讯系统==========");
            System.out.println("\t\t1 登陆系统");
            System.out.println("\t\t2 退出系统");
            System.out.print("请输入你的选择：");
            key = myScanner.next();
            //根据输入的业务进行相应的操作
            switch (key){
                case "1":
                    System.out.print("请输入用户号：");
                    userID = myScanner.next();
                    System.out.print("请输入密 码：");
                    pwd = myScanner.next();
                    //在这里与服务器传入userID和pwd。来判断是否该用户是否注册，用户名密码是否正确

                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
        System.out.println("退出网络通讯系统");
    }
}
