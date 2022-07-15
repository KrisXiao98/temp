package TankGame;

public class Hero extends Tank{

    //定义一个shot对象
    Shot shot = null;
    public Hero() {
    }

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank(){
        //根据当前hero的位置和方向创建子弹
        switch (getDirection()){
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //启动shot线程
        new Thread(shot).start();
    }
}
