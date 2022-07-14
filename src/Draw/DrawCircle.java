package Draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{//JFrame对应窗口，理解成画框
    //定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();

    }

    public DrawCircle(){
        //初始化面板
        mp = new MyPanel();
        //把面板放入窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(400,300);
        //点击x号，真正退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可显示
    }
}


//1.先定义一个MyPanel,继承JPanel类，画图形，就在画板上画
class MyPanel extends JPanel {

    //说明：
    // MyPanel对象，是一个画板
    //Graphics g， g 是一个画笔
    //Graphics 有很多画图的方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画圆
        g.drawOval(10,10,100,100);
    }

}