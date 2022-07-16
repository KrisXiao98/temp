package TankGame;

import javax.swing.*;

public class TankGame03 extends JFrame{
    //定义panel
    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame03 tankGame01 = new TankGame03();
    }

    public TankGame03() {
        mp = new MyPanel();
        //必须添加启动pannel线程
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
