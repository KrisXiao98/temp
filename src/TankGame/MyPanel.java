package TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了监听键盘时间，需要继承KeyListen
public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    //写敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);
        //设置速度
        hero.setSpeed(2);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        //画敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
        }
    }


    /**
     * @param x         坦克左上角坐标
     * @param y         左上角y坐标
     * @param g         画笔
     * @param direction 方向 上下左右
     * @param type      类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        //根据不同方向绘制不同坦克
        //0 1 2 3 表上右下左
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//画左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画主体
                g.fillOval(x + 10, y + 20, 20, 20);//圆
                g.drawLine(x + 20, y + 30, x + 20, y);//炮管
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);//画上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画主体
                g.fillOval(x + 20, y + 10, 20, 20);//圆
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮管
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);//画左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画主体
                g.fillOval(x + 10, y + 20, 20, 20);//圆
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮管
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);//画上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画主体
                g.fillOval(x + 20, y + 10, 20, 20);//圆
                g.drawLine(x + 30, y + 20, x, y + 20);//炮管
                break;
            default:
                System.out.println("暂时没处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirection(0);
            //修改坦克坐标
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.moveULeft();
        }

        //如果按下j键，就发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        //面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
